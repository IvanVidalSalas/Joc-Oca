package com.example.exercici1;

public class Persona {

    private String name;
    private String lastname;
    private int age;

    Persona(String name, String lastname, int age ) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom ='" + name + '\'' + ", cognom='" + lastname + '\'' + ", edat=" + age + '}';
    }

}
