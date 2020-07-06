package com.example.jetpacktest.astudy.at

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R

class AtActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var btnAdd: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_at)
        initView()
        val textColor: Int = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        editText = findViewById(R.id.edittext)

        var s = "@123456"

        editText.setText(s)
        val editable: Editable = editText.text

        editable.setSpan(ForegroundColorSpan(textColor), 0, s.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        LogPrintUtil.zhangshi(editable.toString())

    }

    private fun initView() {
        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            editText.append("@我啊我啊")
        }
    }
}