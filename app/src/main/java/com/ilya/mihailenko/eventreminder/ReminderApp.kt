package com.ilya.mihailenko.eventreminder

import android.app.NotificationManager
import com.ilya.mihailenko.eventreminder.common.notification.ReminderNotificationChannels
import com.ilya.mihailenko.eventreminder.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber
import javax.inject.Inject


class ReminderApp : DaggerApplication() {

    @Inject
    lateinit var notificationChannels: ReminderNotificationChannels

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        JodaTimeAndroid.init(this)
        notificationChannels.init()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}