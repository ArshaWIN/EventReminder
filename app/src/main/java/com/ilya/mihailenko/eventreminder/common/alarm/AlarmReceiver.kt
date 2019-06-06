package com.ilya.mihailenko.eventreminder.common.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ilya.mihailenko.eventreminder.common.notification.NotificationParams
import com.ilya.mihailenko.eventreminder.common.notification.NotificationType
import com.ilya.mihailenko.eventreminder.common.notification.ReminderPushNotificationManager
import com.ilya.mihailenko.eventreminder.utils.ext.getExtraData
import dagger.android.AndroidInjection
import javax.inject.Inject


class AlarmReceiver : BroadcastReceiver() {

    @Inject
    lateinit var notificationManager: ReminderPushNotificationManager

    override fun onReceive(context: Context, intent: Intent) {
        AndroidInjection.inject(this, context)

        val notificationParams = NotificationParams.fromBundle(intent.getExtraData())
        notificationParams?.let { notificationManager.showNotification(it) }
    }
}