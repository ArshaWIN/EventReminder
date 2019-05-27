package com.ilya.mihailenko.eventreminder.presentation.pickdate

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TimePicker
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.utils.ext.roundUpMinutes
import org.joda.time.DateTime


class TimePickerDialogFragment : MvpAppCompatDialogFragment() {

    private lateinit var onDateTimeChangeListener: OnDateTimeChangeListener

    private val openParams: TimePickerOpenParams  by lazy {
        TimePickerOpenParams.fromBundle(arguments)
            ?: throw IllegalStateException("No TimePickerOpenParams was set")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        onDateTimeChangeListener = when {
            context is OnDateTimeChangeListener -> context
            parentFragment is OnDateTimeChangeListener -> parentFragment as OnDateTimeChangeListener
            else -> throw IllegalStateException(
                "Activity or fragment hosting " + DatePickerDialogFragment::class.java.simpleName
                        + " must implement " + OnDateTimeChangeListener::class.java.simpleName
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dateTime = openParams.date

        val roundedMinutes = dateTime.roundUpMinutes(openParams.minuteStep)

        dateTime = dateTime.withMinuteOfHour(roundedMinutes)

        val dialog = TimePickerDialog(
            requireContext(),
            R.style.DateTimePickerStyle,
            OnTimeSetListenerImpl(dateTime),
            dateTime.hourOfDay,
            dateTime.minuteOfHour,
            true
        )

        dialog.window?.setGravity(Gravity.CENTER)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return dialog
    }

    private inner class OnTimeSetListenerImpl constructor(
        private var dateTime: DateTime
    ) : TimePickerDialog.OnTimeSetListener {

        override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
            dateTime = dateTime.withHourOfDay(hourOfDay)
                .withMinuteOfHour(minute)
            onDateTimeChangeListener.onDateTimeChanged(dateTime)
        }
    }

    companion object {
        fun newInstance(openParams: TimePickerOpenParams?) =
            TimePickerDialogFragment().apply {
                arguments = Bundle().apply {
                    openParams?.toBundle(this)
                }
            }
    }
}