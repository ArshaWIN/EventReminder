package com.ilya.mihailenko.eventreminder.entity

import org.joda.time.DateTime


data class Event(
    val id: Int? = null,
    val name: String,
    val description: String,
    val reminderDate: DateTime,
    val createdAt: DateTime = DateTime.now()
)