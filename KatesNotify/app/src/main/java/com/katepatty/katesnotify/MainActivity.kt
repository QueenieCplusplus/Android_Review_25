package com.katepatty.katesnotify


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationBuilderWithBuilderAccessor
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {


    var btn: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notier() // init the NotificationManager in background
        val btn: ImageButton = findViewById(R.id.btn)
        btn.setOnClickListener { manager.notify(2, builder.build())
        }
    }

    lateinit var manager: NotificationManager
    lateinit var builder : Notification.Builder

    fun notier() {
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("kate", "kate", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
            builder = Notification.Builder(this, "kate")
        } else {
            builder = Notification.Builder(this)
        }

        builder.setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("PattyAppier")
            .setContentText("Dear Dummy Coder, Let's have a walk under sunshine.")
            //.setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher_test))
            .setAutoCancel(true)
    }


}