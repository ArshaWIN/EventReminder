package com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter


interface EventViewModel {
    fun getEventTitle(): String
    fun getEventDescription(): String
    fun getEventDate(): String
}