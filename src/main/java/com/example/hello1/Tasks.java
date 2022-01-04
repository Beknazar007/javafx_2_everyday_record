package com.example.hello1;

public class Tasks {
    private String recId;
    private String rec;
    private String recDate;

    public Tasks() {
        this.recId = recId;
        this.rec = rec;
        this.recDate = recDate;
    }
    public Tasks(String s, String text, String leavingText, String hoursstText, String format){}

    public void setTaskId(String recId) {
        this.recId = recId;
    }

    public void setTask(String rec) {
        this.rec = rec;
    }

    public void setTaskDate(String recDate) {
        this.recDate = recDate;
    }

    public String getTaskId() {
        return recId;
    }

    public String getTask() {
        return rec;
    }

    public String getTaskDate() {
        return recDate;
    }

}
