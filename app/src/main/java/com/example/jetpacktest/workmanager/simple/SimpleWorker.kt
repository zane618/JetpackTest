package com.example.jetpacktest.workmanager.simple

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.workmanager.TAG

/**
 * created by zhangshi on 2020/5/23.
 */
class SimpleWorker(context: Context, params: WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {
        Log.e(TAG, "do work in SimpleWorker")
        LogPrintUtil.zhangshi(System.currentTimeMillis().toString())
        return Result.success()
    }
}