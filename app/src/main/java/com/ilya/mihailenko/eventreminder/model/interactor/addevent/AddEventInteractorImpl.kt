package com.ilya.mihailenko.eventreminder.model.interactor.addevent

import com.ilya.mihailenko.eventreminder.common.alarm.AlarmParams
import com.ilya.mihailenko.eventreminder.common.alarm.ReminderAlarmManager
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import io.reactivex.Completable


class AddEventInteractorImpl(
    private val eventsRepository: EventsRepository,
    private val alarmManager: ReminderAlarmManager
) : AddEventInteractor {

    override fun addEvent(alarmParams: AlarmParams): Completable {
        return Completable.fromCallable { alarmManager.createAlarm(alarmParams) }
            .andThen(eventsRepository.saveEvent(alarmParams.eventInfo))
    }
}