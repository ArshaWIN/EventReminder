package com.ilya.mihailenko.eventreminder.model.repository.event

import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single


interface EventsRepository {
    fun observeEvents(): Flowable<List<Event>>
    fun getEvents(): Single<List<Event>>
    fun saveEvent(event: Event): Completable
}