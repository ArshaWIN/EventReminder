package com.ilya.mihailenko.eventreminder.presentation.addevent

import org.joda.time.DateTime


data class AddEventInfo(
    var eventDateTime: DateTime = DateTime.now(),
    var name: String = "",
    var description: String = ""
)