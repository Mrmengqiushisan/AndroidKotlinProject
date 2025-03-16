package com.example.broadcastbestpractice.baseability

import android.app.Activity

object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActitivy(activity: Activity) {
        if (activities.contains(activity)) {
            activities.remove(activity)
        }
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }

}