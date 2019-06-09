package com.ilya.mihailenko.eventreminder.model.interactor.addevent

import com.ilya.mihailenko.eventreminder.common.alarm.ReminderAlarmManager
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import io.reactivex.Completable


class AddEventInteractorImpl(
    private val eventsRepository: EventsRepository,
    private val alarmManager: ReminderAlarmManager
) : AddEventInteractor {

    override fun addEvent(event: Event): Completable {
        return Completable.fromCallable { alarmManager.createAlarm(event) }
            .andThen(eventsRepository.saveEvent(event))
    }
}