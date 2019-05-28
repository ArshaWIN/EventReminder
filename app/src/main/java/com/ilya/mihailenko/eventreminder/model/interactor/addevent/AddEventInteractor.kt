package com.ilya.mihailenko.eventreminder.model.interactor.addevent

import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Completable


interface AddEventInteractor {
    fun addEvent(eventDto: Event): Completable
}