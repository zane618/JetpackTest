package com.example.jetpacktest.astudy.event.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import cn.zane.probase.util.LogPrintUtil

/**
 * created by zhangshi on 2020/5/30.
 */
class MyView : View {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("MyView: dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("MyView: onTouchEvent：" + Const.getEventActionName(event!!.action))
//        return super.onTouchEvent(event)
        return false
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
//        LogPrintUtil.zhangshi("ViewGroupB-B: setOnTouchListener")
        super.setOnTouchListener(l)
    }



    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int): super(context, attrs, defStyle)

}