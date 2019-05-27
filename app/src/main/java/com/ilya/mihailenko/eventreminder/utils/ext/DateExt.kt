package com.ilya.mihailenko.eventreminder.utils.ext

import org.joda.time.DateTime


fun DateTime.roundUpMinutes(minutesStep: Int): Int {
    var roundedMinute = minuteOfHour / minutesStep * minutesStep
    if (roundedMinute < minuteOfHour) {
        roundedMinute += minutesStep
    }
    return roundedMinute % 60
}