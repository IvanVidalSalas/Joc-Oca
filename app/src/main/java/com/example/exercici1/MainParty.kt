package com.example.exercici1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var et_Jugador1: EditText
    lateinit var et_Jugador2: EditText
    lateinit var tv_nJugador1: TextView
    lateinit var tv_nJugador2: TextView
    lateinit var tv_CJugador1: TextView
    lateinit var tv_CJugador2: TextView
    lateinit var tv_alerta: TextView
    lateinit var iv_dau: ImageView
    lateinit var iv_OcaJugador1: ImageView
    lateinit var iv_OcaJugador2: ImageView
    lateinit var joc: Joc
    lateinit var btnTirar: Button
    var tornJugador = 0
    var textCanviat = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        et_Jugador1 = findViewById(R.id.et_Jugador1)
        et_Jugador2 = findViewById(R.id.et_Jugador2)
        tv_nJugador1 = findViewById(R.id.tv_nJugador1)
        tv_nJugador2 = findViewById(R.id.tv_nJugador2)
        tv_alerta = findViewById(R.id.tv_alerta)
        iv_dau = findViewById(R.id.iv_dau)
        tv_CJugador1 = findViewById(R.id.tv_CJugador1)
        tv_CJugador2 = findViewById(R.id.tv_CJugador2)
        btnTirar = findViewById(R.id.btntirar)
        iv_OcaJugador1 = findViewById(R.id.iv_OcaJugador1)
        iv_OcaJugador2 = findViewById(R.id.iv_OcaJugador2)


        btnTirar.setOnClickListener {
            if (!textCanviat) {
                iniciarPartida()
            } else {
                jugarPartida()
            }
        }
    }

    private fun iniciarPartida() {

        val name_Jugador1 = et_Jugador1.text.toString()
        val name_Jugador2 = et_Jugador2.text.toString()


        if (name_Jugador1.isNotEmpty() && name_Jugador2.isNotEmpty()) {
            tv_alerta.visibility = View.INVISIBLE
            tv_nJugador1.visibility = View.VISIBLE
            tv_nJugador2.visibility = View.VISIBLE
            iv_dau.visibility = View.VISIBLE
            iv_OcaJugador1.visibility = View.INVISIBLE
            iv_OcaJugador2.visibility = View.INVISIBLE

            val jugadors = arrayOf(
                Jugador(name_Jugador1, 1),
                Jugador(name_Jugador2, 1)
            )

            joc = Joc(63, jugadors)

            btnTirar.text = "Tirar Dau"
            textCanviat = true

            jugarPartida()

        } else {
            tv_alerta.text = "Si us plau, introdueix els noms dels jugadors"
            tv_alerta.visibility = View.VISIBLE
        }
    }

    private fun jugarPartida() {

        val jugador = joc.players[tornJugador]

        tv_CJugador1.visibility = if (tornJugador == 0) View.VISIBLE else View.INVISIBLE
        tv_CJugador2.visibility = if (tornJugador == 1) View.VISIBLE else View.INVISIBLE

        val tirada = Random.nextInt(1, 7)

        when(tirada) {
            1 -> iv_dau.setImageResource(R.mipmap.diceone)
            2 -> iv_dau.setImageResource(R.mipmap.dicetwo)
            3 -> iv_dau.setImageResource(R.mipmap.dicethree)
            4 -> iv_dau.setImageResource(R.mipmap.dicefour)
            5 -> iv_dau.setImageResource(R.mipmap.dicefive)
            6 -> iv_dau.setImageResource(R.mipmap.dicesix)
        }

        var novaPosicio = jugador.position + tirada

        if (novaPosicio > joc.caselles) {
            novaPosicio = joc.caselles - (novaPosicio - joc.caselles)
        }

        jugador.position = novaPosicio
        tv_nJugador1.text = "${joc.players[0].position}"
        tv_nJugador2.text = "${joc.players[1].position}"

        var repetirTorn = false

        iv_OcaJugador1.visibility = View.INVISIBLE
        iv_OcaJugador2.visibility = View.INVISIBLE

        if (joc.esOca(novaPosicio)) {

            if (tornJugador == 0) {
                iv_OcaJugador1.visibility = View.VISIBLE
            } else {
                iv_OcaJugador2.visibility = View.VISIBLE
            }

            novaPosicio = joc.obtenirSeguentOca(novaPosicio)

            if (novaPosicio > joc.caselles) {
                novaPosicio = joc.caselles - (novaPosicio - joc.caselles)
            }
            jugador.position = novaPosicio
            repetirTorn = true
        }

        tv_nJugador1.text = "${joc.players[0].position}"
        tv_nJugador2.text = "${joc.players[1].position}"

        if (joc.guanyadorPartida() != null) {

            tv_alerta.text = "Enhorabona ${jugador.getName()}, has guanyat la partida!"
            tv_alerta.visibility = View.VISIBLE

            btnTirar.isEnabled = false

        } else {
            if (!repetirTorn) {
                tornJugador = (tornJugador + 1) % joc.players.size
            }
        }
    }
}

