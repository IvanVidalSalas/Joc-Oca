package com.example.exercici1;

import java.util.Random;

public class Joc implements Resultat {

    private int caselles;
    private int [] players;
    private int daus;

    Joc(int caselles, int [] players, int daus) {
        this.caselles = caselles;
        this.players = players;
        this.daus = daus;
    }

    public int  TirarDaus(){
        Random random = new Random();
        int tirada = random.nextInt(6) + 1;
        return tirada;
    }


    public int getCaselles() {
        return caselles;
    }
    public void setCaselles(int caselles) {
        this.caselles = caselles;
    }

    public int[] getPlayers() {
        return players;
    }
    public void setPlayers(int[] players) {
        this.players = players;
    }

    public int getDaus() {
        return daus;
    }
    public void setDaus(int daus) {
        this.daus = daus;
    }

    @Override
    public Jugador JugadorGuanyador() {
        return null;
    }
}
