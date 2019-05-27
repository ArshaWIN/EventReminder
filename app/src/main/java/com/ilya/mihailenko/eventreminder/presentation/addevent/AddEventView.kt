package com.ilya.mihailenko.eventreminder.presentation.addevent

import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseView
import com.ilya.mihailenko.eventreminder.presentation.pickdate.DatePickerOpenParams
import com.ilya.mihailenko.eventreminder.presentation.pickdate.TimePickerOpenParams
import org.joda.time.DateTime


interface AddEventView : BaseView {
    fun hideKeyboard()
    fun showDatePicker(openParams: DatePickerOpenParams)
    fun showTimePicker(openParams: TimePickerOpenParams)
}