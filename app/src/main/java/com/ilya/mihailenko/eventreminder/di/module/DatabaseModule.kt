package com.ilya.mihailenko.eventreminder.di.module

import android.arch.persistence.room.Room
import com.ilya.mihailenko.eventreminder.ReminderApp
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDao
import com.ilya.mihailenko.eventreminder.model.data.database.EventReminderDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: ReminderApp): EventReminderDatabase {
        return Room
            .databaseBuilder(
                application,
                EventReminderDatabase::class.java,
                EventReminderDatabase.DB_NAME
            )
//TODO temp
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Reusable
    fun provideEventDao(database: EventReminderDatabase): EventDao {
        return database.eventDao()
    }
}