package com.example.jetpacktest.livedatabean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktest.R

/**
 * 未完成的、失败的demo 本来是想操作livedata的map和switchMap转换符的
 */
class BeanLivedataActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var infoText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bean_live_data)
        initView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.userName.observe(this, Observer {

        })

    }

    private fun initView() {

        infoText = findViewById(R.id.infoText)

        findViewById<Button>(R.id.plusOneBtn).setOnClickListener { v ->
            viewModel.plusOne()
        }

        findViewById<Button>(R.id.clearBtn).setOnClickListener { v ->
            viewModel.clear()
        }
    }
}
