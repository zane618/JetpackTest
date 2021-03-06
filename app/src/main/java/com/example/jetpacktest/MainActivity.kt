package com.example.jetpacktest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktest.astudy.alarmmanager.AlarmActivity
import com.example.jetpacktest.astudy.at.AtActivity
import com.example.jetpacktest.astudy.event.EventActivity
import com.example.jetpacktest.astudy.service.MyService
import com.example.jetpacktest.astudy.service.ServiceActivity
import com.example.jetpacktest.lifecyclers.MyObserver
import com.example.jetpacktest.livedata.LiveDataActivity
import com.example.jetpacktest.livedatabean.BeanLivedataActivity
import com.example.jetpacktest.room.Room2
import com.example.jetpacktest.room.RoomActivity
import com.example.jetpacktest.viewmodel.MainViewModel
import com.example.jetpacktest.viewmodel.MainViewModelFactory
import com.example.jetpacktest.workmanager.WorkManagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var infoText: TextView
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver(lifecycle))

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)

        infoText = findViewById(R.id.infoText)
        val plus = findViewById<Button>(R.id.plusOneBtn)
        plus.setOnClickListener { v ->
            viewModel.counter++
            refreshCount()
        }
        val clear: Button = findViewById(R.id.clearBtn)
        clear.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                viewModel.counter = 0
                refreshCount()
            }
        })
        refreshCount()

        findViewById<Button>(R.id.go_live_data).setOnClickListener { v ->
            startActivity(Intent(this, LiveDataActivity::class.java))
        }

        findViewById<Button>(R.id.go_bean_live_data).setOnClickListener { v ->
            startActivity(Intent(this, BeanLivedataActivity::class.java))
        }
        findViewById<Button>(R.id.go_room).setOnClickListener { v ->
            startActivity(Intent(this, RoomActivity::class.java))
        }
        findViewById<Button>(R.id.go_wordManager).setOnClickListener { v ->
            startActivity(Intent(this, WorkManagerActivity::class.java))
        }
        findViewById<Button>(R.id.go_eventActivity).setOnClickListener { v ->
            startActivity(Intent(this, EventActivity::class.java))
        }
        findViewById<Button>(R.id.startservice).setOnClickListener { v ->
            startActivity(Intent(this, ServiceActivity::class.java))
        }
        findViewById<Button>(R.id.startAtActivity).setOnClickListener { v ->
            startActivity(Intent(this, AtActivity::class.java))
        }
        findViewById<Button>(R.id.startAlarmActivity).setOnClickListener { v ->
            startActivity(Intent(this, AlarmActivity::class.java))
        }
    }

    private fun refreshCount() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter)
        }
    }

    override fun onResume() {
        super.onResume()
//        startActivity(Intent(this, AtActivity::class.java))
    }
}
