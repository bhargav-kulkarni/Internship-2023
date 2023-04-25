package com.example.LogViewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Services {


    Logger logger= LoggerFactory.getLogger(Services.class);


    @Autowired
    RedisService redisService;

    /**
     *
     * @param dockerContainerInfo
     * @return
     */
    public List<DockerContainer> getDockerContainerList(List<String> dockerContainerInfo)
    {
        List<DockerContainer> dockerContainers=new ArrayList<>();
        for(String s:dockerContainerInfo)
        {
            s=s.replace("   ","  ");
            s=s.trim();
            String s1[]=(s.split("  "));
            dockerContainers.add(new DockerContainer(s1[0],s1[1],s1[4],null));
        }
        return  dockerContainers;
    }

    @Scheduled(cron = "0 */2 * ? * *")
    public void assignTaskScheduler() throws InterruptedException {


        List<String> dockerList=getRunningContainer("powershell.exe docker ps");
        List<DockerContainer> dockerContainers=getDockerContainerList(dockerList);
        ExecutorService executor = Executors.newFixedThreadPool(dockerContainers.size()*2);
        for (DockerContainer dockerContainer:dockerContainers)
        {
            executor.submit(() -> {
              LogsViewer logsViewer=  getAllLogs(dockerContainer.getContainerID());
              System.out.println(logsViewer.getLogsSet());

            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    }



    /**
     *
     * @param command
     * @return
     */
    public List<String> getRunningContainer(String command) {


        List<String> result=new ArrayList<>();
        try {
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            powerShellProcess.getOutputStream().close();
            String line;
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getInputStream()));
            stdout.readLine();
            while ((line = stdout.readLine()) != null) {
                result.add(line);
            }
            stdout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.size()==0)
        {
            result.add("No Running docker container");
        }
        return  result;
    }

    /**
     * @return
     */
    public  LogsViewer  getAllLogs(String command)
    {

        Set<LogsViewer> logsViewers=new HashSet<>();
        Set<String> logsErrorSets=new HashSet<>();
        String command1="powershell.exe docker logs "+command+" 2>&1 |  findstr 'Exception | ERROR: | error | exception'";
        try {
            Process powerShellProcess = Runtime.getRuntime().exec(command1);
            powerShellProcess.getOutputStream().close();

            String line;
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getInputStream()));
            stdout.readLine();
            while ((line = stdout.readLine()) != null) {
                if(!logsErrorSets.contains(line)) {
                    logsErrorSets.add(line);
                }
            }
            stdout.close();

        } catch (Exception e) {

            logger.error(e.toString());
        }
        if(logsViewers.size()==0)
        {
            Set<String> hashSet=new HashSet<>();
            hashSet.add("No Error found...");
            logsViewers.add(new LogsViewer(null,hashSet));
        }
        LogsViewer logsViewer=new LogsViewer(command,logsErrorSets);

        redisService.setLogs(logsViewer);
        return logsViewer;
    }

}
