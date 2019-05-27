package com.ilya.mihailenko.eventreminder

import com.ilya.mihailenko.eventreminder.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber


class ReminderApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        JodaTimeAndroid.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}