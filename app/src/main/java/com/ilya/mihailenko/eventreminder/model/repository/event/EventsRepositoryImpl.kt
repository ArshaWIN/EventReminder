package com.ilya.mihailenko.eventreminder.model.repository.event

import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.data.database.EventDao
import io.reactivex.Completable
import io.reactivex.Flowable


class EventsRepositoryImpl(
    private val eventDao: EventDao
) : EventsRepository {

    override fun addEvent(event: Event): Completable =
        Completable.fromAction { eventDao.insert(event) }


    override fun observeEvents(): Flowable<List<Event>> =
        eventDao.getData()
}