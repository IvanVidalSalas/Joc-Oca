package com.example.exercici1

import java.util.Scanner

fun main()  {

    println("Benvinguts al Joc de l'Oca!")
    val scanner = Scanner(System.`in`)

    println("Quants jugadors hi haurà?: ")
    val qjugadors = scanner.nextInt()
    scanner.nextLine()

    val jugadors = mutableListOf<Jugador>()

    for (jugador in 1..qjugadors) {
        println("Jugador $jugador")
        println("Nom: ")
        val nom = scanner.nextLine()
        println("Color: ")
        val color = scanner.nextLine()

        jugadors.add(Jugador(nom,color))
    }


}