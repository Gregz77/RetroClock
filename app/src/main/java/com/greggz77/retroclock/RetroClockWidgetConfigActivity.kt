package com.greggz77.retroclock

import android.appwidget.AppWidgetManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_retro_clock_widget_config.*


class RetroClockWidgetConfigActivity : AppCompatActivity() {

    private lateinit var appWidgetText: TextView
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_clock_widget_config)

        digital_clock_text_config.text = CurrentTime().showTime()
        appWidgetText = findViewById(R.id.digital_clock_text_config)
        appWidgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID
    }
}