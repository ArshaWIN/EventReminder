package com.ilya.mihailenko.eventreminder.entity

import com.ilya.mihailenko.eventreminder.common.alarm.AlarmType
import org.joda.time.DateTime


data class Event(
    val id: Int? = null,
    val name: String,
    val description: String,
    val reminderDate: DateTime,
    val createdAt: DateTime = DateTime.now(),
    val isRepeated: Boolean,
    val alarmType: AlarmType
)