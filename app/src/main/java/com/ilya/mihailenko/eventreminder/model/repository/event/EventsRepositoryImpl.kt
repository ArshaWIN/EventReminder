package com.ilya.mihailenko.eventreminder.model.repository.event

import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDao
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDtoMapper
import com.ilya.mihailenko.eventreminder.utils.ext.listMap
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single


class EventsRepositoryImpl(
    private val eventDao: EventDao,
    private val eventDtoMapper: EventDtoMapper
) : EventsRepository {

    override fun saveEvent(event: Event): Completable =
        Completable.fromAction { eventDao.insert(eventDtoMapper.mapperFrom().map(event)) }


    override fun observeEvents(): Flowable<List<Event>> =
        eventDao.observeData()
            .listMap { eventDtoMapper.mapperTo().map(it) }

    override fun getEvents(): Single<List<Event>> =
        eventDao.getData()
            .listMap { eventDtoMapper.mapperTo().map(it) }
}