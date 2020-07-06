package com.example.jetpacktest.astudy.at

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.widget.EditText
import cn.zane.probase.util.LogPrintUtil

/**
 * create by zhangshi on 2020/7/1.
 */
class AtEditText: androidx.appcompat.widget.AppCompatEditText{

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
        LogPrintUtil.zhangshi("selStart: " + selStart + " , selEnd: " + selEnd)

        val range = Range(0, 7)
        if (selStart == selEnd) {
            setSelection(range.getAnchorPosition(selStart))
        } else{
            if (selEnd < range.to) {
                setSelection(selStart, range.to)
            }
            if (selStart > range.from) {
                setSelection(range.from, selEnd)
            }
        }
    }

    fun insertAtText(atStr: String) {
        val spannableString: SpannableString = SpannableString(atStr + " ")
        val length = spannableString.length
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#3700B3")), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


    }
}