package com.example.jetpacktest.room

import androidx.room.*

/**
 * created by zhangshi on 2020/5/22.
 */
@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User): Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers(): List<User>

    @Query("select * from User where age > :age")
    fun loadUsersOlderThan(age: Int): List<User>

    @Delete
    fun delete(user: User)

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName: String): Int


    @Query("select * from User order by id desc limit 3 ")
    fun loadLast3() : List<User>

    /**
     * 删除start和end之间的数据（包含start和end
     */
    @Query("delete from User where id >= :start & id <= :end")
    fun deleteRange(start: Long, end: Long): Int

}