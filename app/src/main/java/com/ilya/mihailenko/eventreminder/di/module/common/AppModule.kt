package com.ilya.mihailenko.eventreminder.di.module.common

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.content.Context.ALARM_SERVICE
import com.ilya.mihailenko.eventreminder.ReminderApp
import com.ilya.mihailenko.eventreminder.di.AppContext
import com.ilya.mihailenko.eventreminder.di.scopes.PerActivity
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDao
import com.ilya.mihailenko.eventreminder.model.data.database.event.EventDtoMapper
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    @AppContext
    fun provideContext(application: ReminderApp): Context = application.applicationContext

    @Provides
    fun provideNotificationManager(@AppContext context: Context): NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @Provides
    fun provideAlarmManager(@AppContext context: Context): AlarmManager =
        context.getSystemService(ALARM_SERVICE) as AlarmManager

    @Provides
    @Singleton
    fun provideEventRepository(
        eventDao: EventDao,
        eventDtoMapper: EventDtoMapper
    ): EventsRepository {
        return EventsRepositoryImpl(eventDao, eventDtoMapper)
    }
}
