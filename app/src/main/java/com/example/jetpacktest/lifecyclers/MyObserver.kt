package com.example.jetpacktest.lifecyclers

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * created by zhangshi on 2020/5/22.
 */
class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.e("MyObserver:", "activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.e("MyObserver:", "activityStop")
    }
}