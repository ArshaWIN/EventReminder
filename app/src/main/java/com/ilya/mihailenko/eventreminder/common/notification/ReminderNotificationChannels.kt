package com.ilya.mihailenko.eventreminder.common.notification

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.di.AppContext

import javax.inject.Inject

const val MAIN_CHANNEL_ID = "chat_channel"
const val BIRTHDAY_CHANNEL_ID = "birthday_channel"

class ReminderNotificationChannels @Inject constructor(
    @AppContext private val context: Context,
    private val notificationManager: NotificationManager
) {

    fun init() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }

        val notificationChannels = listOf(
            getMainNotificationChannel(),
            getBirthdayNotificationChannel()
        )
        notificationManager.createNotificationChannels(notificationChannels)
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun getMainNotificationChannel(): NotificationChannel =
        NotificationChannel(
            MAIN_CHANNEL_ID,
            context.getString(R.string.notification_channel_main),
            NotificationManager.IMPORTANCE_HIGH
        )

    @TargetApi(Build.VERSION_CODES.O)
    private fun getBirthdayNotificationChannel(): NotificationChannel =
        NotificationChannel(
            BIRTHDAY_CHANNEL_ID,
            context.getString(R.string.notification_channel_birthday),
            NotificationManager.IMPORTANCE_HIGH
        )
}
