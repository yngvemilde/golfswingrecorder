package com.example.golfswingrecorder

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log

class SwingService : Service() {

    private val CHANNEL_ID = "golf_swing_channel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        Log.d("SwingService", "Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("GolfSwingRecorder")
            .setContentText("Venter på slag…")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)
        Log.d("SwingService", "Service started in foreground")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SwingService", "Service destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Golf Swing Recorder",
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java)
                .createNotificationChannel(channel)
        }
    }
}
