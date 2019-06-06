package com.ilya.mihailenko.eventreminder.common.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ilya.mihailenko.eventreminder.common.notification.NotificationParams
import com.ilya.mihailenko.eventreminder.common.notification.NotificationType
import com.ilya.mihailenko.eventreminder.di.AppContext
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.utils.ext.putExtraData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ReminderAlarmManager @Inject constructor(
    @AppContext private val context: Context,
    private val alarmManager: AlarmManager
) {

    fun createAlarm(alarmParams: AlarmParams) {
        val alarmType = alarmParams.alarmType

        when (alarmType) {
            AlarmType.NOTIFICATION -> createNotificationAlarm(alarmParams)
            AlarmType.WAKELOCK -> {
            }
        }
    }

    private fun createNotificationAlarm(alarmParams: AlarmParams) {
        val eventInfo = alarmParams.eventInfo
        val intent = createAlarmIntent(eventInfo)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            123,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            eventInfo.reminderDate.millis,
            pendingIntent
        )
    }

    private fun createAlarmIntent(eventInfo: Event): Intent {
        val data = Bundle()
        val notificationParams =
            NotificationParams(eventInfo.name, eventInfo.description, NotificationType.MAIN)
        notificationParams.toBundle(data)
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.putExtraData(data)
        return intent
    }
}