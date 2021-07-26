package com.example.parkingsystemkotlin.mvp.view.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference<Activity>(activity)

    val activity: Activity?
        get() = activityRef.get()

    val fragmentManager
        get() = (activity as AppCompatActivity).supportFragmentManager
}
