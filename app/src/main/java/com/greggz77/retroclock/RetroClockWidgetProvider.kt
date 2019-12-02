package com.greggz77.retroclock

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class RetroClockWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
            //Toast.makeText(context, "Widgets have been updated! ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val widgetText = CurrentTime().showTime()
        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.retro_clock_widget)
        views.setTextViewText(R.id.digital_clock_text, widgetText)
        views.setOnClickPendingIntent(R.id.retro_clock_widget_layout, getPendingIntent(context, appWidgetId))
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
    private fun getPendingIntent(context: Context, value: Int): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        return PendingIntent.getActivity(context, 0, intent, 0)
    }
}