package com.ilya.mihailenko.eventreminder.presentation.pickdate

import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime


private const val EXTRA_OPEN_PARAMS = "pick_time_params"

@Parcelize
class TimePickerOpenParams(
    val date: DateTime,
    val allowDateInThePast: Boolean = true,
    val minuteStep: Int = 1
) : Parcelable {
    fun toBundle(bundle: Bundle) {
        bundle.putParcelable(EXTRA_OPEN_PARAMS, this)
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle?): TimePickerOpenParams? {
            return bundle?.getParcelable(EXTRA_OPEN_PARAMS)
        }
    }
}