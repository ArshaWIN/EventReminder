package com.ilya.mihailenko.eventreminder.model.repository.event

import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDto
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDao
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDtoMapper
import com.ilya.mihailenko.eventreminder.utils.ext.listMap
import io.reactivex.Completable
import io.reactivex.Flowable


class EventsRepositoryImpl(
    private val eventDao: EventDao,
    private val eventDtoMapper: EventDtoMapper
) : EventsRepository {

    override fun addEvent(event: Event): Completable =
        Completable.fromAction { eventDao.insert(eventDtoMapper.mapperFrom().map(event)) }


    override fun observeEvents(): Flowable<List<Event>> =
        eventDao.getData()
            .listMap { eventDtoMapper.mapperTo().map(it) }
}