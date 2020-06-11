package com.example.jetpacktest.astudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.LogPrinter;

import androidx.annotation.Nullable;

import cn.zane.probase.util.LogPrintUtil;

/**
 * created by zhangshi on 2020/6/6.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogPrintUtil.INSTANCE.zhangshi("onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogPrintUtil.INSTANCE.zhangshi("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogPrintUtil.INSTANCE.zhangshi("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogPrintUtil.INSTANCE.zhangshi("onDestroy");
    }
}
