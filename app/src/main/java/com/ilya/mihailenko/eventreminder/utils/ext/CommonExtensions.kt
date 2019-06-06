package com.ilya.mihailenko.eventreminder.utils.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager

private val DATA_KEY = "DATA"

fun Activity.hideKeyboard() {
    currentFocus?.apply {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun Intent.putExtraData(data: Bundle) {
    putExtra(DATA_KEY, data)
}

fun Intent.getExtraData(): Bundle? {
    return getBundleExtra(DATA_KEY)
}