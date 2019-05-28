package com.ilya.mihailenko.eventreminder.model.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDto
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDao


@Database(entities = [EventDto::class], version = EventReminderDatabase.VERSION)
@TypeConverters(Converters::class)
abstract class EventReminderDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "reminder.db"
        const val VERSION = 1
    }

    abstract fun eventDao(): EventDao
}