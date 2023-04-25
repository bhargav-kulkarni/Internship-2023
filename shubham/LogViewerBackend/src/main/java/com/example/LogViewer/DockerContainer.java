package com.example.LogViewer;


public class DockerContainer{
    String containerID;
    String image;
    String Name;
    String logs;
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public DockerContainer(String containerID, String image, String name, String logs) {
        this.containerID=containerID;
        this.image = image;
        Name = name;
        this.logs = logs;
    }

    public DockerContainer() {
    }


    public String getContainerID() {
        return containerID;
    }



    public String getLogs() {
        return logs;
    }

    public void setDockerID(String containerID) {
        this.containerID = containerID;
    }



    public void setLogs(String logs) {
        this.logs = logs;
    }


}
