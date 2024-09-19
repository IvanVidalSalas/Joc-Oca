package com.example.exercici1

import java.util.Scanner

fun main()  {

    println("Benvinguts al Joc de l'Oca!")
    val scanner = Scanner(System.`in`)
    scanner.nextLine()

    println("Quants jugadors hi haurà? ")
    val num_jugadors = scanner.nextInt()
    scanner.nextLine()

    val jugadors = mutableListOf<Jugador>()

    for (jugador in 1..num_jugadors) {
        println("Jugador $jugador")

        println("Nom: ")
        val nom = scanner.nextLine()

        println("Cognom: ")
        val cognom = scanner.nextLine()

        println("Edat: ")
        val edat = scanner.nextInt()
        scanner.nextLine()

        println("Nickname: ")
        val nickname = scanner.nextLine()

        println("Color: ")
        val color = scanner.nextLine()

        println("Posicio inicial: ")
        val posicio = scanner.nextInt()
        scanner.nextLine()

        jugadors.add(Jugador(nom, cognom, edat, nickname, color, posicio))
    }

    val joc = Joc(63, jugadors.toTypedArray())

    var guanyador: Jugador? = null

    while (guanyador == null) {
        joc.jugarPartida()
        guanyador = joc.guanyadorPartida()
    }

    println("Enhorabona ${guanyador.nickname}, has guanyat la partida!")
}