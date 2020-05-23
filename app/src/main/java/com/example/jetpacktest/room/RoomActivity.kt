package com.example.jetpacktest.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.jetpacktest.R
import com.example.jetpacktest.room.update.Book
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {

    var i: Int = 0

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

        val bookDao = AppDatabase.getDatabase(this).bookDao()
        findViewById<Button>(R.id.addBook).setOnClickListener {
            thread {
                val book = Book("一本好书" + i, 180, "张三")
                book.id = bookDao.findLastzBook().id + 1
                bookDao.insertBook(book)
                Log.e("MainActivityx", book.id.toString())
            }
        }
        findViewById<Button>(R.id.queryBooks).setOnClickListener {
            thread {
                for (book in bookDao.loadAllBooks()) {
                    Log.e("MainActivityx", book.toString())
                }
            }
        }

    }
}
