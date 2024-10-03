package com.example.exercici1;

public class Jugador extends Persona{

    private String color;
    private String nickname;
    private int position;

    Jugador(String name, int position) {
        super(name);
        //this.color = color;
        //this.nickname = nickname;
        this.position = position;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) { this.position = position; }

    @Override
    public String toString() {
        return "Jugador{" + "nom='" + getName() + '\'' +
                ", cognom='" + getLastname() + '\'' +
                ", edat=" + getAge() +
                ", color='" + color + '\'' +
                ", nickname='" + nickname + '\'' +
                ", posicio=" + position +
                '}';
    }
}
