package com.ilya.mihailenko.eventreminder.di.module.common

import com.ilya.mihailenko.eventreminder.common.alarm.AlarmReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BroadcastReceiversProvider {
    @ContributesAndroidInjector
    abstract fun contributesAlarmReceiver() : AlarmReceiver
}