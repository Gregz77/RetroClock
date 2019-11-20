package com.greggz77.retroclock

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    /*val hoursTextMapPol
            = mapOf<String, Int>("Enih" to 1, "Dveh" to 2, "Treh" to 3, "Štirih" to 4, "Petih" to 5, "Šestih" to 6, "Sedmih" to 7, "Osmih" to 8, "Devetih" to 9, "Desetih" to 10, "Enajstih" to 11, "Dvanajstih" to 12)

    val hoursTextMapTricetrt
            = mapOf<String, Int>("Ena" to 1, "Dve" to 2, "Tri" to 3, "Štiri" to 4, "Pet" to 5, "Šest" to 6, "Sedem" to 7, "Osem" to 8, "Devet" to 9, "Deset" to 10, "Enajst" to 11, "Dvanajst" to 12)

    val minutesTextMap
            = mapOf<String, Int>("" to 1, "" to 2, "" to 3, "" to 4, "" to 5, "" to 6, "" to 7,
        "Četrt čez" to 8, "Četrt čez" to 9, "Četrt čez" to 10, "Četrt čez" to 11, "Četrt čez" to 12, "Četrt čez" to 13, "Četrt čez" to 14, "Četrt čez" to 15, "Četrt čez" to 16, "Četrt čez" to 17, "Četrt čez" to 18, "Četrt čez" to 19, "Četrt čez" to 20, "Četrt čez" to 21, "Četrt čez" to 22,
        "Pol" to 23, "Pol" to 24, "Pol" to 25, "Pol" to 26, "Pol" to 27, "Pol" to 28, "Pol" to 29, "Pol" to 30, "Pol" to 31, "Pol" to 32, "Pol" to 33, "Pol" to 34, "Pol" to 35, "Pol" to 36, "Pol" to 37,
        "Tričetrt na" to 38, "Tričetrt na" to 39, "Tričetrt na" to 40, "Tričetrt na" to 41, "Tričetrt na" to 42, "Tričetrt na" to 43, "Tričetrt na" to 44, "Tričetrt na" to 45, "Tričetrt na" to 46, "Tričetrt na" to 47,
        "" to 48, "" to 49, "" to 50, "" to 51, "" to 52, "" to 53, "" to 54, "" to 55, "" to 56, "" to 57, "" to 58, "" to 59, "" to 0)*/


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

        //showTime()
    }
    fun showTime() {
        val sysTime = System.currentTimeMillis()
        val format = SimpleDateFormat("H:m:ss") //or DateFormat.getDateTimeInstance()
        val timeString = format.format(sysTime)
        textview.text = timeString
    }
    fun updateClock() {

    }
}