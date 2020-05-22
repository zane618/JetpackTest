package com.example.jetpacktest.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.jetpacktest.R
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        findViewById<Button>(R.id.addDataBtn).setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        findViewById<Button>(R.id.updateDataBtn).setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        findViewById<Button>(R.id.deleteDataBtn).setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
                userDao.deleteUserByLastName("Brady")
            }

        }
        findViewById<Button>(R.id.queryDataBtn).setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.e("MainActivityx", user.toString())
                }
            }
        }

    }
}
