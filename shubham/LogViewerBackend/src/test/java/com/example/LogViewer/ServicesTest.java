package com.example.LogViewer;

import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ServicesTest {

    @Mock
    Controller controller1;

    @Mock
    Services services;
    @Test
    public void commandExecutionfetchedData()
    {
        String command="docker ps";
        List<String> l=new ArrayList<>();
        when(services.getRunningContainer(command)).thenReturn(l);
        List<String> commandExecutionResult = services.getRunningContainer(command);
        Assert.assertEquals(true,commandExecutionResult.size()==0);

    }
    @Test
    public void CommandExecutionNoContainer()
    {
        String command="docker ps";
        List<String> list=new ArrayList<>();
        list.add("Error not found");
        when(services.getRunningContainer(command)).thenReturn(list);
        List<String> commandExecutionResult=services.getRunningContainer(command);
        Assert.assertEquals(1,commandExecutionResult.size());

    }


}
