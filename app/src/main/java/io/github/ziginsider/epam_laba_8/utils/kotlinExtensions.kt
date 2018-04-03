package io.github.ziginsider.epam_laba_8.utils

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.github.ziginsider.epam_laba_8.BuildConfig

fun logd(className: String, message: String) {
    if (BuildConfig.DEBUG) Log.d(className, message)
}

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

//inflate view
infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)

//integer to dp
val Int.asDp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

//portrait and landscape orientation
fun Activity.isPortrait()
        = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT