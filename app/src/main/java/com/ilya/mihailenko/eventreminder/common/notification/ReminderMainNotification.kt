package com.ilya.mihailenko.eventreminder.common.notification

import android.content.Context
import android.support.v4.app.TaskStackBuilder


const val MAIN_NOTIFICATION_ID: Int = 123454321
const val MAIN_NOTIFICATION_TAG: String = "MAIN_NOTIFICATION_TAG"

class ReminderMainNotification(
    context: Context,
    private val notificationParams: NotificationParams
) : BasePushNotification(context) {


    override fun getId(): Int = MAIN_NOTIFICATION_ID

    override fun getTag(): String = MAIN_NOTIFICATION_TAG

    override fun getTitle(): CharSequence = notificationParams.title

    override fun getContent(): CharSequence = notificationParams.content

    override fun getTaskStack(): TaskStackBuilder? = null

    override fun getChannelId(): String = notificationParams.notificationType.channelId
}