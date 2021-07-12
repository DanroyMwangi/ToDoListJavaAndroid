package com.danroy.todolistredo;

public class Task {
    private String taskName,taskStartTime,taskCompletion;

    public Task(String taskName, String taskTime){
        this.taskCompletion = "Incomplete";
        this.taskName = taskName;
        this.taskStartTime = taskTime;
    }

    public void setTaskCompletion(String taskCompletion) {
        this.taskCompletion = taskCompletion.equals("0")?"Incomplete":taskCompletion.equals("1")?"Complete":"Invalid";
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskStartTime(String taskTime) {
        this.taskStartTime = taskTime;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public String getTaskCompletion() {
        return taskCompletion;
    }

    public String getTaskName() {
        return taskName;
    }
}
