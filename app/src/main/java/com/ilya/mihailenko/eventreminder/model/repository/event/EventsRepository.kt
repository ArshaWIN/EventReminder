package com.ilya.mihailenko.eventreminder.model.repository.event

import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Completable
import io.reactivex.Flowable


interface EventsRepository {
    fun observeEvents(): Flowable<List<Event>>
    fun addEvent(event: Event): Completable
}