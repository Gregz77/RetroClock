package com.greggz77.retroclock

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Send a broadcast so that the Operating system updates the widget
        val man = AppWidgetManager.getInstance(this)
        val ids = man.getAppWidgetIds(
            ComponentName(this, RetroClockWidget::class.java)
        )
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                textview.text = CurrentTime().showTime()
                mainHandler.postDelayed(this, 60000)

                val updateIntent = Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
                updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
                sendBroadcast(updateIntent)
            }
        })
    }
}