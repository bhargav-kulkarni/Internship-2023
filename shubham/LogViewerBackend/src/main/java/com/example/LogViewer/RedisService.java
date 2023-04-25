package com.example.LogViewer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    LogRepository logRepository;

    @Cacheable(value = "containerId")
    public Optional<LogsViewer> getLogs(String containerId)
    {
         return logRepository.findById(containerId);
    }

    @CachePut(value = "LogsViewer")
    public LogsViewer setLogs(LogsViewer logsViewers)
    {
        logRepository.save(logsViewers);
        return logsViewers;
    }
}
