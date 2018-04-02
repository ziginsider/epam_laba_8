package io.github.ziginsider.epam_laba_8.utils

import android.app.Activity
import android.util.Log
import io.github.ziginsider.epam_laba_8.BuildConfig

fun Activity.logd(message: String) {
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}