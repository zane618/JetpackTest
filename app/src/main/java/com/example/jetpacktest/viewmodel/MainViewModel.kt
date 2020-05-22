package com.example.jetpacktest.viewmodel

import androidx.lifecycle.ViewModel

/**
 * created by zhangshi on 2020/5/21.
 */
class MainViewModel(countReserved: Int) : ViewModel() {
    var counter = countReserved

}