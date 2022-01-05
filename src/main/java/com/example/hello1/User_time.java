package com.example.hello1;

public class User_time {
    private String userId;
    private String coming;
    private String leaving;
    private String studying;
    private String recDate;

    public User_time(String userId,String coming, String leaving, String hoursst, String recDate){
        this.userId     = userId;
        this.coming     = coming;
        this.leaving    = leaving;
        this.studying   = hoursst;
        this.recDate    = recDate;
    }
    public User_time() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setComing(String coming) {
        this.coming = coming;
    }

    public void setLeaving(String leaving) {
        this.leaving = leaving;
    }

    public void setStudying(String studying) {
        this.studying = studying;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getComing() {
        return coming;
    }

    public String getLeaving() {
        return leaving;
    }

    public String getStudying() {
        return studying;
    }

    public String getRecDate() {
        return recDate;
    }


}
