package com.example.jetpacktest.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R
import com.example.jetpacktest.databinding.ActivityWorkManagerBinding
import com.example.jetpacktest.workmanager.simple.SimpleWorker
import java.time.Duration
import java.util.concurrent.TimeUnit

const val TAG = "workManagerActivity"

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityWorkManagerBinding  = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)

        dataBinding.btnSimpleWorker.setOnClickListener {
            //第一步 很复杂，简单些点创建Request
            LogPrintUtil.zhangshi(System.currentTimeMillis().toString())
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            val requestRepeat = PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15,
            TimeUnit.MINUTES)
                .setInitialDelay(6, TimeUnit.MINUTES) //延迟5分钟后执行
                .addTag("simple") //可以根据tag取消任务，调用cancelWorkByTag
                .build()
            WorkManager.getInstance(this).enqueue(requestRepeat)
            Handler().postDelayed(Runnable {
                LogPrintUtil.zhangshi("handler:" + System.currentTimeMillis().toString())
            },1000 * 60)
        }

    }
}
