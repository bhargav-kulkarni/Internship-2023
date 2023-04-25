package com.example.LogViewer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.*;

import org.springframework.stereotype.Component;


@Entity
@Component
public class LogsViewer {

    @Id
    String containerId;

    @Column(name = "LOGS_SET", columnDefinition = "TEXT")
    Set<String> logsSet;

    public LogsViewer(String containerId, Set<String> logsSet) {
        this.containerId = containerId;
        this.logsSet = logsSet;
    }

    public LogsViewer() {
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public Set<String> getLogsSet() {
        return logsSet;
    }

    public void setLogsSet(Set<String> logsSet) {
        this.logsSet = logsSet;
    }
}
