package com.example.todoapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService

class AlarmReceiver : BroadcastReceiver() {
    private val NOTIFICATION_ID = 2002
    private val CHANNEL_ID = "ChannelID"
    override fun onReceive(context: Context?, p1: Intent?) {

        context?.let {

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            val notification = NotificationCompat.Builder(it)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentText("Alarm Reminder")
                .setSubText("Focus on finishing your task!")
                .setChannelId(CHANNEL_ID)
                .build()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        CHANNEL_ID,
                        "Reminder",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }
            notificationManager.notify(NOTIFICATION_ID,notification)
        }

    }
}