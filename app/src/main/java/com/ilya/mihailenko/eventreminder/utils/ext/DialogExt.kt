package com.ilya.mihailenko.eventreminder.utils.ext

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

/**
 * Close all {@link DialogFragment}s from {@link FragmentManager}
 *
 * @return true if closed any
 */
fun FragmentManager.closeAllDialogs(): Boolean {
    val dialogs: List<DialogFragment> = fragments
        .asSequence()
        .filter { fragment -> fragment is DialogFragment }
        .map { it as DialogFragment }
        .toList()

    dialogs.forEach(DialogFragment::dismiss)
    return !dialogs.isEmpty()
}