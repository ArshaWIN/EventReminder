package com.ilya.mihailenko.eventreminder.common.alarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.ilya.mihailenko.eventreminder.common.notification.NotificationParams
import com.ilya.mihailenko.eventreminder.common.notification.NotificationType
import com.ilya.mihailenko.eventreminder.di.AppContext
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.utils.ext.putExtraData
import org.joda.time.DateTime
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ReminderAlarmManager @Inject constructor(
    @AppContext private val context: Context,
    private val alarmManager: AlarmManager
) {

    fun createAlarm(event: Event) {
        val alarmType = event.alarmType

        when (alarmType) {
            AlarmType.NOTIFICATION -> createNotificationAlarm(event)
            AlarmType.WAKELOCK -> {
            }
        }
    }

    private fun createNotificationAlarm(event: Event) {
        val intent = createAlarmIntent(event)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            123,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        setAlarm(event.reminderDate, pendingIntent)
    }

    @SuppressLint("NewApi")
    private fun setAlarm(dateTime: DateTime, pendingIntent: PendingIntent) {
        val sdkVersion = Build.VERSION.SDK_INT
        when {
            sdkVersion >= Build.VERSION_CODES.M -> alarmManager.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                dateTime.millis,
                pendingIntent
            )
            sdkVersion >= Build.VERSION_CODES.KITKAT -> alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                dateTime.millis,
                pendingIntent
            )
            else -> alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime.millis, pendingIntent)
        }
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