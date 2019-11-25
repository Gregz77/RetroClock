package com.greggz77.retroclock

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                showTime()
                mainHandler.postDelayed(this, 1000)
            }
        })
    }
    fun showTime() {

        val minutesPattern = "m"
        val hoursPattern = "h"
        val currentTime = LocalTime.now()

        fun currentTimeString() {

            val minutesFormatter: DateTimeFormatter =
                DateTimeFormatter.ofPattern(minutesPattern)
            val currentMinutes = minutesFormatter.format(currentTime).toInt()
            val hourFormatter: DateTimeFormatter =
                DateTimeFormatter.ofPattern(hoursPattern)
            var currentHour = hourFormatter.format(currentTime).toInt()
            var currentMinutesString: String
            var currentHourString = ""

            println("///////////////////////////////////////////////////////// $currentHour //////////////////////////////////////////////")
            println("///////////////////////////////////////////////////////// $currentMinutes ///////////////////////////////////////////")

            when (currentMinutes) {
                in 8..22 -> {
                    currentMinutesString = "Četrt čez"
                    println("----------------------------------------------$currentMinutesString----------------------------------------------")
                }
                in 23..37 -> {
                    currentMinutesString = "Pol"
                    println("----------------------------------------------$currentMinutesString---------------------------------------------")
                }
                in 38..52 -> {
                    currentMinutesString = "Tričetrt na"
                    println("----------------------------------------------$currentMinutesString---------------------------------------------")
                }
                else -> {//currentMinutes in 53..7
                    currentMinutesString = ""
                    println("----------------------------------------------$currentMinutesString---------------------------------------------")
                }
            }
            if (currentMinutes in 23..59) {
                currentHour += 1
            }

            when (currentHour) {
                0 -> currentHourString = "Polnoč"
                1 -> currentHourString = "Ena"
                2 -> currentHourString = "Dve"
                3 -> currentHourString = "Tri"
                4 -> currentHourString = "Štiri"
                5 -> currentHourString = "Pet"
                6 -> currentHourString = "Šest"
                7 -> currentHourString = "Sedem"
                8 -> currentHourString = "Osem"
                9 -> currentHourString = "Devet"
                10 -> currentHourString = "Deset"
                11 -> currentHourString = "Enajst"
                12 -> currentHourString = "Poldan"

            }
            textview.text = "$currentMinutesString $currentHourString"
        }
        currentTimeString()
    }
}