package com.example.jetpacktest.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by zhangshi on 2020/5/22.
 */
@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


}