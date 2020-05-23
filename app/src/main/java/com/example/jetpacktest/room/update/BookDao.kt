package com.example.jetpacktest.room.update

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * created by zhangshi on 2020/5/23.
 */
@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book): Long

    @Query("select * from Book")
    fun loadAllBooks(): List<Book>

    @Query("SELECT * FROM Book ORDER BY id DESC LIMIT 1")
    fun findLastzBook(): Book
}