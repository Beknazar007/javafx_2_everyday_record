package com.example.newrecord;

public class Wishes_Module_class {
    String name;
    String surname;
    String wishes;
    String date;




    public Wishes_Module_class(String name, String surname, String wishes, String date) {
        this.name = name;
        this.surname = surname;
        this.wishes = wishes;
        this.date = date;
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

    public String getDate() {
        return date;
    }
}
