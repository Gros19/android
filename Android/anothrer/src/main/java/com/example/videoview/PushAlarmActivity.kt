package com.example.videoview

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.videoview.databinding.ActivityPushAlarmBinding

class PushAlarmActivity : AppCompatActivity() {
    val binding by lazy { ActivityPushAlarmBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button9.setOnClickListener { ShowNotification("제목", "내용") }
    }

    fun ShowNotification(Title:String, Body:String){
        val pending = PendingIntent.getActivity(this, 0, Intent(this, PushAlarmActivity::class.java), PendingIntent.FLAG_CANCEL_CURRENT)
        val builder = NotificationCompat.Builder(this, "id")
        builder.setContentTitle(Title)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText(Body)
            .setContentIntent(pending)
            .setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)

        val NManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NManager.createNotificationChannel(NotificationChannel("id","name", NotificationManager.IMPORTANCE_HIGH))
        }
        NManager.notify(0, builder.build())
    }
}