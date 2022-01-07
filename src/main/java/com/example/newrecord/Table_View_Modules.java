package com.example.newrecord;

public class Table_View_Modules {


    String name;
    String surname;
    String wishes;
    String recDate;

    public Table_View_Modules(   String name, String surname, String studying, String recDate) {


        this.name = name;
        this.surname = surname;
        this.wishes = studying;
        this.recDate    = recDate;
    }







    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getWishes() {
        return wishes;
    }

    public String getRecDate() {
        return recDate;
    }




    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }
}
