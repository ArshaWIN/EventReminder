package com.ilya.mihailenko.eventreminder.presentation.addevent

import android.databinding.ObservableField


interface AddEventViewModel {
    fun getTimeText(): ObservableField<String>
    fun getDateText(): ObservableField<String>

    interface Handler {
        fun onSaveClick()
        fun onDateClick()
        fun onTimeClick()
    }
}