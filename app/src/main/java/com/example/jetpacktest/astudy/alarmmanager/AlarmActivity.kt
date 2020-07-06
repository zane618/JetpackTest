package com.example.jetpacktest.astudy.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        findViewById<Button>(R.id.start).setOnClickListener {
        }

        findViewById<Button>(R.id.stop).setOnClickListener {
        }

    }
}