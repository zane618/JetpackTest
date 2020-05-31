package com.example.jetpacktest.astudy.event

import android.R.id.button1
import android.R.id.button2
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R
import com.example.jetpacktest.databinding.ActivityEventBinding


class EventActivity : AppCompatActivity() {

    lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event)

        initViews()
    }

    private fun initViews() {
//        binding.viewGroupA.setOnClickListener{
//            LogPrintUtil.zhangshi("点击了ViewGroup")
//        }


    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        LogPrintUtil.zhangshi("dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        LogPrintUtil.zhangshi("onTouchEvent")
        return super.onTouchEvent(event)
    }



    override fun onUserInteraction() {
//        LogPrintUtil.zhangshi("onUserInteraction")
        super.onUserInteraction()
    }
}
