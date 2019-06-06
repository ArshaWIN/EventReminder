package com.ilya.mihailenko.eventreminder.common.notification


enum class NotificationType(val channelId: String) {
    MAIN(MAIN_CHANNEL_ID),
    BIRTHDAY(BIRTHDAY_CHANNEL_ID)
}
