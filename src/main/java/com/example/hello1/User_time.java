package com.example.hello1;

public class User_time {
    private String recId;
    private String rec;
    private String recDate;

    public User_time() {
        this.recId = recId;
        this.rec = rec;
        this.recDate = recDate;
    }
    public User_time(String s, String comming, String leaving, String hoursst, String format){}

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public void setRecDate(String recDate) {
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
