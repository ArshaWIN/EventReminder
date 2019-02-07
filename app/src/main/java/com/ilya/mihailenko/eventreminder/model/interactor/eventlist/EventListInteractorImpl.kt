package com.ilya.mihailenko.eventreminder.model.interactor.eventlist

import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import io.reactivex.Flowable


class EventListInteractorImpl(
    private val eventsRepository: EventsRepository
) : EventListInteractor {
    override fun observeEvents(): Flowable<List<Event>> =
        eventsRepository.observeEvents()
}