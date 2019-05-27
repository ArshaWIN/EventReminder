package com.ilya.mihailenko.eventreminder.presentation.pickdate

import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

private const val EXTRA_OPEN_PARAMS = "pick_date_params"

@Parcelize
class DatePickerOpenParams(
    val date: DateTime,
    val minDate: DateTime? = null
) : Parcelable {
    fun toBundle(bundle: Bundle) {
        bundle.putParcelable(EXTRA_OPEN_PARAMS, this)
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle?): DatePickerOpenParams? {
            return bundle?.getParcelable(EXTRA_OPEN_PARAMS)
        }
    }
}