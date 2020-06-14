package com.example.jetpacktest.astudy.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R

class ServiceActivity : AppCompatActivity() {

    lateinit var tv: TextView
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        tv = findViewById(R.id.tv)
        val filter = IntentFilter()
        filter.addAction("test")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)

        findViewById<View>(R.id.start).setOnClickListener{v ->
            startService(Intent(this, MyService::class.java))
        }
        findViewById<View>(R.id.stop).setOnClickListener{v ->
            stopService(Intent(this, MyService::class.java))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }


    inner class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val s = intent?.getStringExtra("time")
            if (s != null) {
                LogPrintUtil.zhangshi(s)
                tv?.text = s
            }
        }

    }
}
