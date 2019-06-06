package com.ilya.mihailenko.eventreminder.common.alarm

import com.ilya.mihailenko.eventreminder.entity.Event

data class AlarmParams(
    val eventInfo: Event,
    val isRepeated: Boolean,
    val alarmType: AlarmType
)