package com.ilya.mihailenko.eventreminder.common.notification

import android.app.NotificationManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReminderPushNotificationManager @Inject constructor(
    private val notificationManager: NotificationManager,
    private val pushNotificationFabric: PushNotificationFabric
) {

    fun showNotification(notificationParams: NotificationParams) {

        val pushNotification = pushNotificationFabric
            .create(notificationParams)

        notificationManager.notify(
            pushNotification.getTag(), pushNotification.getId(),
            pushNotification.getNotification()
        )
    }
}