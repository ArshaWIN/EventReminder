package com.ilya.mihailenko.eventreminder.model.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ilya.mihailenko.eventreminder.entity.Event


@Database(entities = [Event::class], version = EventReminderDatabase.VERSION)
abstract class EventReminderDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "food.db"
        const val VERSION = 1
    }
    abstract fun EventDao(): EventDao
}