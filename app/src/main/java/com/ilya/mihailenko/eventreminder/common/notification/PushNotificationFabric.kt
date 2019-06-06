package com.ilya.mihailenko.eventreminder.common.notification

import android.content.Context
import com.ilya.mihailenko.eventreminder.di.AppContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PushNotificationFabric @Inject constructor(
    @AppContext private val context: Context
) {

    fun create(notificationParams: NotificationParams): BasePushNotification {
        val type = notificationParams.notificationType

        return when (type) {
            NotificationType.BIRTHDAY -> BirthdayNotification(context, notificationParams)
            NotificationType.MAIN -> ReminderMainNotification(context, notificationParams)
        }
    }
}