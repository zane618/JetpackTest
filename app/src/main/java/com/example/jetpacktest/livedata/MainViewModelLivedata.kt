package com.example.jetpacktest.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * created by zhangshi on 2020/5/22.
 * 结合LiveData的ViewModel
 */
class MainViewModelLivedata(countReserved: Int) : ViewModel() {
    /*val counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }

    fun clear() {
        counter.value = 0
    }*/
    /**
     * 为了不让counter能被非ViewModel类设置值
     */

    private var _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
}