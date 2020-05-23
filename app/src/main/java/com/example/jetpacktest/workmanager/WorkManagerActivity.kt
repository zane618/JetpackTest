package com.example.jetpacktest.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.jetpacktest.R
import com.example.jetpacktest.databinding.ActivityWorkManagerBinding
import com.example.jetpacktest.workmanager.simple.SimpleWorker
import java.util.concurrent.TimeUnit

const val TAG = "workManagerActivity"

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityWorkManagerBinding  = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)

        dataBinding.btnSimpleWorker.setOnClickListener {
            //第一步 很复杂，简单些点创建Request
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            val requestRepeat = PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15,
            TimeUnit.MINUTES)
                .setInitialDelay(5, TimeUnit.MINUTES) //延迟5分钟后执行
                .addTag("simple") //可以根据tag取消任务，调用cancelWorkByTag
                .build()
            WorkManager.getInstance(this).enqueue(requestRepeat)
        }

    }
}
