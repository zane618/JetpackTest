package com.example.jetpacktest.astudy.event.viewgroup

import android.view.MotionEvent

/**
 * created by zhangshi on 2020/5/30.
 */
object Const {
    val ACTIONS = arrayOf("ACTION_DOWN_0","ACTION_UP_1",
    "ACTION_MOVE_2","ACTION_CANCEL_3","ACTION_OUTSIDE_4",
    "ACTION_POINTER_DOWN_5", "ACTION_POINTER_UP_6",
    "ACTION_HOVER_MOVE_7","ACTION_SCROLL_8",
    "ACTION_HOVER_ENTER_9","ACTION_HOVER_EXIT_10")

    fun getEventActionName(eventAction: Int): String{
        if (ACTIONS.size > eventAction) {
            return ACTIONS[eventAction]
        }
        return eventAction.toString()
    }
}