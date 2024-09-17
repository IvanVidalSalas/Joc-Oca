package com.example.exercici1;

public class Persona {

    private String name;
    private String lastname;
    private int year;

    Persona(String name, String lastname, int year ) {
        this.name = name;
        this.lastname = lastname;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
