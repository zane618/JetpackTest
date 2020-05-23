package com.example.jetpacktest.room.update

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by zhangshi on 2020/5/23.
 */
@Entity
data class Book(var name:String, var pages: Int, var author: String) {
    @PrimaryKey
    var id: Long = 0


}