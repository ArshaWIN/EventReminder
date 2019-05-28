package com.ilya.mihailenko.eventreminder.utils.ext

import org.joda.time.DateTime

const val TIME_PATTERN = "HH:mm"
const val DATE_PATTERN = "dd.MM.YYYY"
const val DATE_TIME_PATTERN = "HH:mm E. d MMMM, YYYY"


fun DateTime.roundUpMinutes(minutesStep: Int): Int {
    var roundedMinute = minuteOfHour / minutesStep * minutesStep
    if (roundedMinute < minuteOfHour) {
        roundedMinute += minutesStep
    }
    return roundedMinute % 60
}

fun DateTime.toTimestamp(): Long = millis

fun Long.toDateTime(): DateTime = DateTime(this)

fun DateTime.toReadableTime(): String = toString(TIME_PATTERN)
fun DateTime.toReadableDate(): String = toString(DATE_PATTERN)
fun DateTime.toReadableDateTime(): String = toString(DATE_TIME_PATTERN)