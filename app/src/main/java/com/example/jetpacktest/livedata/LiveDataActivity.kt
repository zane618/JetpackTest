package com.example.jetpacktest.livedata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktest.R
import com.example.jetpacktest.viewmodel.MainViewModelFactory

class LiveDataActivity : AppCompatActivity() {
    lateinit var infoText: TextView
    lateinit var sp: SharedPreferences
    lateinit var viewModelLivedata: MainViewModelLivedata

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_livedata", 0)
        viewModelLivedata = ViewModelProvider(this, MainViewModelFactoryLivedata(countReserved))
            .get(MainViewModelLivedata::class.java)

        initView()

        viewModelLivedata.counter.observe(this,
            Observer { count ->
                infoText.text = count.toString()
            })
        //添加了implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0' 就可以用下面的方式写了
//        viewModelLivedata.counter.observe(this) {
//            count->
//            infoText.text = count.toString()
//        }
    }

    private fun initView() {

        infoText = findViewById(R.id.infoText)
        infoText.text = viewModelLivedata.counter.value.toString()

        findViewById<Button>(R.id.plusOneBtn).setOnClickListener { v ->
            viewModelLivedata.plusOne()
        }

        findViewById<Button>(R.id.clearBtn).setOnClickListener { v ->
            viewModelLivedata.clear()
        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_livedata", viewModelLivedata.counter.value ?: 0)
        }
    }
}
