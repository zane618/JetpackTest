package com.example.jetpacktest.livedatabean

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * created by zhangshi on 2020/5/22.
 */
class MainViewModel(countReserved: Int) : ViewModel() {
    fun plusOne() {
    }

    fun clear() {

    }

    val userLiveData = MutableLiveData<User>()

    val userName: LiveData<String> = Transformations.map(userLiveData) {
        user->
        "${user.firstName} ${user.lastName}"
    }
}