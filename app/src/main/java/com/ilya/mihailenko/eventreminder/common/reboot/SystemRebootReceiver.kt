package com.ilya.mihailenko.eventreminder.common.reboot

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ilya.mihailenko.eventreminder.common.alarm.ReminderAlarmManager
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class SystemRebootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var alarmManager: ReminderAlarmManager

    @Inject
    lateinit var eventsRepository: EventsRepository

    @SuppressLint("CheckResult")
    override fun onReceive(context: Context?, intent: Intent?) {
        AndroidInjection.inject(this, context)

        eventsRepository.getEvents()
            .flatMapObservable { Observable.fromIterable(it) }
            .doOnNext { alarmManager.createAlarm(it) }
            .toList()
            .subscribeOn(Schedulers.io())
            .subscribe({}, Timber::e)
    }
}