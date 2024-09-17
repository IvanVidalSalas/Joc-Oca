package com.example.exercici1;

public class Jugador extends Persona{

    private String color;
    private String nickname;
    private int score;

    Jugador(String name, String lastname, int year, String color, String nickname, int score) {
        super(name,lastname,year);
        this.color = color;
        this.nickname = nickname;
        this.score = score;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
