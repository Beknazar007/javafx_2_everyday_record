package com.example.hello1;

public class User {
    private String lastName;
    private String firstName;
    private String userName;
    private String password;


    public User( String lastName,String firstName, String userName, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;

    }

    public User() {

    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
