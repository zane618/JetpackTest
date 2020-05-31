package com.example.jetpacktest.astudy.event.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import cn.zane.probase.util.LogPrintUtil

/**
 * created by zhangshi on 2020/5/30.
 */
class ViewGroupB : LinearLayout {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupB-B: dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupB-B: onInterceptTouchEvent")
//        return super.onInterceptTouchEvent(ev)
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupB-B: onTouchEvent:" +Const.getEventActionName(event!!.action))
//        return super.onTouchEvent(event)
        return true
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
//        LogPrintUtil.zhangshi("ViewGroupB-B: setOnTouchListener")
        super.setOnTouchListener(l)
    }



    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int): super(context, attrs, defStyle)

}