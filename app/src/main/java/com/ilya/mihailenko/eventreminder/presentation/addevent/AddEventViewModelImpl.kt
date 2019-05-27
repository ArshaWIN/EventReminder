package com.ilya.mihailenko.eventreminder.presentation.addevent

import android.content.res.Resources
import android.databinding.ObservableField
import com.ilya.mihailenko.eventreminder.R
import org.joda.time.DateTime


class AddEventViewModelImpl(
    resources: Resources
) : AddEventViewModel {

    private val datePattern = resources.getString(R.string.date_pattern)
    private val timePattern = resources.getString(R.string.time_pattern)


    private var date: ObservableField<String> =
        ObservableField(DateTime.now().toString(datePattern))
    private var time: ObservableField<String> =
        ObservableField(DateTime.now().toString(timePattern))

    fun setDate(dateTime: DateTime) {
        date.set(dateTime.toString(datePattern))
        time.set(dateTime.toString(timePattern))
    }

    override fun getTimeText(): ObservableField<String> = time
    override fun getDateText(): ObservableField<String> = date

}