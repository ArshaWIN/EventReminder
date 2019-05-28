package com.ilya.mihailenko.eventreminder.presentation.addevent

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.interactor.addevent.AddEventInteractor
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import com.ilya.mihailenko.eventreminder.presentation.pickdate.DatePickerOpenParams
import com.ilya.mihailenko.eventreminder.presentation.pickdate.TimePickerOpenParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.joda.time.DateTime
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class AddEventPresenter @Inject constructor(
    private val router: ExtendedRouter,
    private val addEventInteractor: AddEventInteractor
) : BasePresenter<AddEventView>() {

    private var eventReminderDate = DateTime.now()

    fun onBackPressed() {
        router.exit()
    }

    fun onSaveClick(
        eventName: String,
        eventDescription: String
    ) {

        val event = Event(
            name = eventName,
            description = eventDescription,
            reminderDate = eventReminderDate
        )

        addEventInteractor.addEvent(event)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.hideKeyboard()
                router.exit()
            }, { Timber.e(it) })
            .addDisposable()
    }

    fun onDateClick() {
        val openParams = DatePickerOpenParams(date = eventReminderDate)
        viewState.showDatePicker(openParams)
    }

    fun onTimeClick() {
        val openParams = TimePickerOpenParams(
            date = eventReminderDate,
            allowDateInThePast = false
        )
        viewState.showTimePicker(openParams)
    }

    fun onDateTimeChanged(dateTime: DateTime) {
        eventReminderDate = dateTime
            .withSecondOfMinute(0)
            .withMillisOfSecond(0)
    }
}