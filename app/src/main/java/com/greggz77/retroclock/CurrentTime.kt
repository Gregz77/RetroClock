package com.greggz77.retroclock

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class CurrentTime {

    fun showTime(): String {

        val minutesPattern = "m"
        val hoursPattern = "h"
        val currentTime = LocalTime.now()
        val minutesFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(minutesPattern)
        val currentMinutes = minutesFormatter.format(currentTime).toInt()
        val hourFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(hoursPattern)
        var currentHour = hourFormatter.format(currentTime).toInt()
        val currentMinutesString: String
        var currentHourString = ""

        //println("///////////////////////////////////////////////////////// $currentHour //////////////////////////////////////////////")
        //println("///////////////////////////////////////////////////////// $currentMinutes ///////////////////////////////////////////")

        when (currentMinutes) {
            in 8..22 -> {
                currentMinutesString = "Četrt čez"
                //println("----------------------------------------------$currentMinutesString----------------------------------------------")
            }
            in 23..37 -> {
                currentMinutesString = "Pol"
                //println("----------------------------------------------$currentMinutesString---------------------------------------------")
            }
            in 38..52 -> {
                currentMinutesString = "Tri četrt na"
                //println("----------------------------------------------$currentMinutesString---------------------------------------------")
            }
            else -> {//currentMinutes in 53..7
                currentMinutesString = ""
                //println("----------------------------------------------$currentMinutesString---------------------------------------------")
            }
        }
        if (currentMinutes in 23..59) {
            currentHour += 1
        }
        if (currentMinutes in 23..37) {
            when (currentHour) {
                0 -> currentHourString = "Polnoči"
                1 -> currentHourString = "Enih"
                2 -> currentHourString = "Dveh"
                3 -> currentHourString = "Treh"
                4 -> currentHourString = "Štirih"
                5 -> currentHourString = "Petih"
                6 -> currentHourString = "Šestih"
                7 -> currentHourString = "Sedmih"
                8 -> currentHourString = "Osmih"
                9 -> currentHourString = "Devetih"
                10 -> currentHourString = "Desetih"
                11 -> currentHourString = "Enajstih"
                12 -> currentHourString = "Dvanajstih"
                13 -> currentHourString = "Enih"
            }
        } else {
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
                12 -> currentHourString = "Dvanajst"
                13 -> currentHourString = "Ena"
            }
        }
        return "$currentMinutesString $currentHourString"
    }
}