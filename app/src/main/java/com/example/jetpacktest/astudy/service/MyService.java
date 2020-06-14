package com.example.jetpacktest.astudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.LogPrinter;

import androidx.annotation.Nullable;

import cn.zane.probase.util.LogPrintUtil;

/**
 * created by zhangshi on 2020/6/6.
 */
public class MyService extends Service {

    private CountDownTimer mCountDownTimer;
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
        mCountDownTimer = createCountDown();
        startCountDown();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
        LogPrintUtil.INSTANCE.zhangshi("onDestroy");
    }

    private void startCountDown() {
        if (mCountDownTimer != null) {
            mCountDownTimer.start();
        }
    }

    private CountDownTimer createCountDown() {
        return new CountDownTimer((100000) * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                LogPrintUtil.INSTANCE.zhangshi("onStartCommand: onTick : " + millisUntilFinished);
                Intent intent = new Intent("test");
                intent.putExtra("time", ms2HMS(millisUntilFinished));
                getApplicationContext().sendBroadcast(intent);
            }

            @Override
            public void onFinish() {
                LogPrintUtil.INSTANCE.zhangshi("onStartCommand: onFinish");
            }
        };
    }

    public static String ms2HMS(long _ms){
        String HMStime;
        _ms/=1000;
        long hour=_ms/3600;
        long mint=(_ms%3600)/60;
        long sed=_ms%60;
        String hourStr=String.valueOf(hour);
        if(hour<10){
            hourStr="0"+hourStr;
        }
        String mintStr=String.valueOf(mint);
        if(mint<10){
            mintStr="0"+mintStr;
        }
        String sedStr=String.valueOf(sed);
        if(sed<10){
            sedStr="0"+sedStr;
        }
        HMStime=hourStr+":"+mintStr+":"+sedStr;
        return HMStime;
    }
}
