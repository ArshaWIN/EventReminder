package com.ilya.mihailenko.eventreminder.model.interactor.addevent

import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import io.reactivex.Completable


class AddEventInteractorImpl(
    private val eventsRepository: EventsRepository
) : AddEventInteractor {

    override fun addEvent(event: Event): Completable =
        eventsRepository.addEvent(event)
}