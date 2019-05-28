package com.ilya.mihailenko.eventreminder.presentation.addevent

import android.databinding.ObservableField
import com.ilya.mihailenko.eventreminder.utils.ext.toReadableDate
import com.ilya.mihailenko.eventreminder.utils.ext.toReadableTime
import org.joda.time.DateTime


class AddEventViewModelImpl : AddEventViewModel {

    private var date: ObservableField<String> =
        ObservableField(DateTime.now().toReadableDate())
    private var time: ObservableField<String> =
        ObservableField(DateTime.now().toReadableTime())

    fun setDate(dateTime: DateTime) {
        date.set(dateTime.toReadableDate())
        time.set(dateTime.toReadableTime())
    }

    override fun getTimeText(): ObservableField<String> = time
    override fun getDateText(): ObservableField<String> = date

}