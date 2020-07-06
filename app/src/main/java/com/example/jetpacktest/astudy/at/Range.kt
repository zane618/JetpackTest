package com.example.jetpacktest.astudy.at

/**
 * create by zhangshi on 2020/7/1.
 */
class Range(var from: Int = 0, var to: Int = 0) {
    
    fun isWrappedBy(start: Int, end: Int): Boolean {
        return start > from && start < to || end > from && end < to
    }

    fun contains(start: Int, end: Int): Boolean {
        return from <= start && to >= end
    }

    fun isEqual(start: Int, end: Int): Boolean {
        return from == start && to == end || from == end && to == start
    }

    fun getAnchorPosition(value: Int): Int {
        return if (value - from - (to - value) >= 0) {
            to
        } else {
            from
        }
    }
}