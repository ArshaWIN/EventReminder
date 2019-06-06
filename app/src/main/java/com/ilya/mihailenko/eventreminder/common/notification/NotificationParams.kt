package com.ilya.mihailenko.eventreminder.common.notification

import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

private const val EXTRA_OPEN_PARAMS = "notification_params"

@Parcelize
class NotificationParams(
    val title: String,
    val content: String,
    val notificationType: NotificationType
) : Parcelable {

    fun toBundle(bundle: Bundle) {
        bundle.putParcelable(EXTRA_OPEN_PARAMS, this)
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle?): NotificationParams? {
            return bundle?.getParcelable(EXTRA_OPEN_PARAMS)
        }
    }
}