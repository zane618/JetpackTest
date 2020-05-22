package com.example.jetpacktest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktest.livedata.MainViewModelLivedata

/**
 * created by zhangshi on 2020/5/21.
 */
class MainViewModelFactory(private val countReserved: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(countReserved) as T
//        return MainViewModelLivedata(countReserved) as T
    }
}