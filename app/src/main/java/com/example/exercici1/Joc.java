package com.example.exercici1;

import java.util.Random;
import java.util.Scanner;

public class Joc implements Resultat {

    int caselles;
    Jugador [] players;
    int [] casellesOca = new int[]{5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};

    Joc(int caselles, Jugador [] players) {
        this.caselles = caselles;
        this.players = players;
    }

    public int tirarDaus(){
        Random random = new Random();
        int tirada = random.nextInt(6) + 1;
        return tirada;
    }

    public boolean esOca(int posicio){
        for (int casella : casellesOca) {
            if (casella == posicio) {
                return true;
            }
        }
        return false;
    }

    public int obtenirSeguentOca(int posicio) {
        for (int casella : casellesOca) {
            if (casella > posicio) {
                return casella;
            }
        }
        return posicio;
    }

    public void jugarPartida() {

        Scanner scanner = new Scanner(System.in);

        for (Jugador jugador : players) {

            boolean mogut = true;

            while (mogut) {

                System.out.println("Li toca tirar a " + jugador.getName());
                scanner.nextLine();

                int tirada = tirarDaus();
                int novaPosicio = jugador.getPosition() + tirada;

                if (novaPosicio > caselles) {
                    System.out.println(jugador.getName() + " ha tirat un " + tirada + " i està a la casella " + novaPosicio);
                    System.out.println(jugador.getName() + " t'has passat de la casella " + caselles);
                    mogut = false;
                    continue;
                }

                jugador.setPosition(novaPosicio);
                System.out.println(jugador.getName() + " ha tirat un " + tirada + " i està a la casella " + novaPosicio);

                if (esOca(novaPosicio)) {
                    System.out.println(jugador.getName() + " ha caigut en una casella d'Oca!");
                    novaPosicio = obtenirSeguentOca(novaPosicio);

                    if (novaPosicio > caselles) {
                        novaPosicio = caselles - (novaPosicio - caselles);
                    }

                    jugador.setPosition(novaPosicio);
                    System.out.println(jugador.getName() + " avança a la casella " + novaPosicio);

                } else {
                    mogut = false;
                }
            }

            if (guanyadorPartida() != null) {
                break;
            }
        }
    }

    @Override
    public Jugador guanyadorPartida() {
        for (Jugador jugador : players) {
            if (jugador.getPosition() == caselles) {
                return jugador;
            }
        }
        return null;
    }
}
