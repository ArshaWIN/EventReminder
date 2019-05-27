package com.ilya.mihailenko.eventreminder.presentation.pickdate

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.DatePicker
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.ilya.mihailenko.eventreminder.R
import org.joda.time.DateTime


class DatePickerDialogFragment : MvpAppCompatDialogFragment() {

    private lateinit var onDateTimeChangeListener: OnDateTimeChangeListener

    private val openParams: DatePickerOpenParams  by lazy {
        DatePickerOpenParams.fromBundle(arguments)
            ?: throw IllegalStateException("No DatePickerOpenParams was set")
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
        val dateTime = openParams.date

        val dialog = DatePickerDialog(
            requireContext(),
            R.style.AppTheme,
            OnDateSetListenerImpl(dateTime),
            dateTime.year,
            dateTime.monthOfYear - 1,
            dateTime.dayOfMonth
        )

        dialog.window?.setGravity(Gravity.CENTER)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return dialog
    }

    companion object {
        fun newInstance(openParams: DatePickerOpenParams?) =
            DatePickerDialogFragment().apply {
                arguments = Bundle().apply {
                    openParams?.toBundle(this)
                }
            }
    }

    private inner class OnDateSetListenerImpl constructor(
        private var dateTime: DateTime
    ) : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
            dateTime = dateTime.withDate(year, month + 1, dayOfMonth)
            onDateTimeChangeListener.onDateTimeChanged(dateTime)
        }
    }
}