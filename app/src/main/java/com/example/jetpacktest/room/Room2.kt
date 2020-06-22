package com.example.jetpacktest.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import cn.zane.probase.util.LogPrintUtil
import com.example.jetpacktest.R
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class Room2 : AppCompatActivity(), View.OnClickListener {
    lateinit var add: Button
    lateinit var delete: Button
    lateinit var select: Button
    lateinit var btn_test: Button
    lateinit var userDao: UserDao
    var nameIndex: Int = 0
    val singleThreadExecutor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room2)
        userDao = AppDatabase.getDatabase(applicationContext).userDao()
        inivews()

    }

    override fun onClick(v: View?) {
        when (v) {
            add -> {
                singleThreadExecutor.execute {
                    val index = ++nameIndex
                    val user = User("First-" + index, "Last-" + index, index)
                    LogPrintUtil.zhangshi("user before: " + user.toString())
                    val id = userDao.insertUser(user)
                    LogPrintUtil.zhangshi("id: " + id)
                    LogPrintUtil.zhangshi("user after : " + user)
                }
            }
            delete -> {

            }
            select -> {
                thread {
                    LogPrintUtil.zhangshi("select")
                    val userList = userDao.loadAllUsers()
                    for (user in userList) {
                        LogPrintUtil.zhangshi(user.toString())
                    }
                }
            }
            btn_test -> {
                thread {
                    LogPrintUtil.zhangshi("btn_test")
                    val userList = userDao.loadLast3()
                    for (user in userList) {
                        LogPrintUtil.zhangshi(user.toString())
                    }
                    if (userList.size > 0) {
                        val start = userList.get(0).id
                        val end = userList.get(userList.size - 1).id
                        val deleteCount = userDao.deleteRange(start, end)
                        LogPrintUtil.zhangshi("deleteCount: " + deleteCount)
                    }
                }
            }
        }

    }

    private fun inivews() {
        add = findViewById(R.id.add)
        delete = findViewById(R.id.delete)
        select = findViewById(R.id.select)
        btn_test = findViewById(R.id.btn_test)
        add.setOnClickListener(this)
        delete.setOnClickListener(this)
        select.setOnClickListener(this)
        btn_test.setOnClickListener(this)
    }
}
