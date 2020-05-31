package com.example.jetpacktest.astudy.event.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import cn.zane.probase.util.LogPrintUtil

/**
 * created by zhangshi on 2020/5/30.
 */
class ViewGroupA : LinearLayout {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupA: dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupA: onInterceptTouchEvent")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        LogPrintUtil.zhangshi("ViewGroupA: onTouchEvent:" + Const.getEventActionName(event!!.action))
        return super.onTouchEvent(event)
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
//        LogPrintUtil.zhangshi("ViewGroupA: setOnTouchListener")
        super.setOnTouchListener(l)
    }



    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int): super(context, attrs, defStyle)

}