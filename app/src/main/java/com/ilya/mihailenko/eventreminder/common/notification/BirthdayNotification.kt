package com.ilya.mihailenko.eventreminder.common.notification

import android.content.Context
import android.support.v4.app.TaskStackBuilder

const val BIRTHDAY_NOTIFICATION_ID: Int = 12341241
const val BIRTHDAY_NOTIFICATION_TAG: String = "BIRTHDAY_NOTIFICATION_TAG"

class BirthdayNotification(
    context: Context,
    private val notificationParams: NotificationParams
) : BasePushNotification(context) {


    override fun getId(): Int = BIRTHDAY_NOTIFICATION_ID

    override fun getTag(): String = BIRTHDAY_NOTIFICATION_TAG

    override fun getTitle(): CharSequence = notificationParams.title

    override fun getContent(): CharSequence = notificationParams.content

    override fun getTaskStack(): TaskStackBuilder? = null

    override fun getChannelId(): String = notificationParams.notificationType.channelId
}