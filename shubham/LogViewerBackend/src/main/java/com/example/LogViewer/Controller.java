package com.example.LogViewer;
import java.util.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
public class Controller {

     @Autowired
     LogsViewer logsDetector;

     @Autowired
      Services services;
     @Autowired
      RedisService redisService;
     Logger logger= LoggerFactory.getLogger(Controller.class);
     Set<String> logsErrorSet=new HashSet<>();


    /**
     *
     * @return
     */

    @Scheduled(cron = "0 0/2 * ? * *")
    @GetMapping("/api/dockerContainer")
    public List<DockerContainer> getAllDockerContainer()
    {
        logger.debug("Create new Process");
        String command = "powershell.exe docker ps";
        List<String> dockerContainerInfo = services.getRunningContainer("powershell.exe docker ps");

        List<DockerContainer>  dockerContainers = (dockerContainerInfo.size()>0) ? services.getDockerContainerList(dockerContainerInfo) : null;
        return dockerContainers;
    }

    /**
     *
     * @param ContainerId of Docker container
     * @return getAllLogs method return Error logs present ContainerId
     */

    @GetMapping("/api/logs/{ContainerId}")
    public  LogsViewer  getAllLogs(@PathVariable String ContainerId)
    {
         Optional<LogsViewer> logSet=redisService.getLogs(ContainerId);
         if(!logSet.isEmpty())
         {
             Optional<LogsViewer> logsViewer = logSet;
             LogsViewer result = logsViewer.orElseThrow(() -> new IllegalArgumentException("LogsViewer not found"));
             return  result;
         }
         else {
             return services.getAllLogs(ContainerId);
         }

    }





    }

