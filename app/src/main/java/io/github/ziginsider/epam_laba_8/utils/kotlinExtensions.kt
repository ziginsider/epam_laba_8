package io.github.ziginsider.epam_laba_8.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_8.BuildConfig

fun android.support.v4.app.Fragment.logd(message: String) {
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}

fun android.support.v4.app.Fragment.logd(className: String, message: String) {
    if (BuildConfig.DEBUG) Log.d(className, message)
}

//inflate view
infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)