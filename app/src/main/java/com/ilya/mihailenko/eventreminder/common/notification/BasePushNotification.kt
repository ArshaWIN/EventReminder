package com.ilya.mihailenko.eventreminder.common.notification

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import com.ilya.mihailenko.eventreminder.R

abstract class BasePushNotification constructor(
    protected val context: Context
) {

    private val builder: NotificationCompat.Builder by lazy { createDefaultNotificationBuilder() }

    abstract fun getTag(): String

    abstract fun getTitle(): CharSequence

    abstract fun getContent(): CharSequence

    abstract fun getTaskStack(): TaskStackBuilder?

    abstract fun getChannelId(): String

    abstract fun getId() : Int

    fun getNotification(): Notification {
        val title = getTitle()
        if (!title.isEmpty()) {
            builder.setContentTitle(title)
        }

        return builder
            .setContentText(getContent())
            .setContentIntent(getIntent())
            .build()
    }


    private fun getIntent(): PendingIntent? {
        val taskStack = getTaskStack()
        return taskStack?.getPendingIntent(
            12344321,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_ONE_SHOT
        )
    }

    @Suppress("DEPRECATION")
    private fun createDefaultNotificationBuilder(): NotificationCompat.Builder {
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        return NotificationCompat.Builder(context, getChannelId())
            .setSmallIcon(R.drawable.notify_panel_notification_icon_bg)
            .setContentTitle(context.getString(R.string.push_notification_title))
            .setPriority(Notification.PRIORITY_HIGH)
            .setSound(defaultSoundUri)
            .setAutoCancel(true)
    }
}
