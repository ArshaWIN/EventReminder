package com.ilya.mihailenko.eventreminder.presentation.pickdate

import org.joda.time.DateTime

interface OnDateTimeChangeListener {
    fun onDateTimeChanged(dateTime: DateTime)
}
