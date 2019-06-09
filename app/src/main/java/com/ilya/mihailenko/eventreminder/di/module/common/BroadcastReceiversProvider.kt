package com.ilya.mihailenko.eventreminder.di.module.common

import com.ilya.mihailenko.eventreminder.common.alarm.AlarmReceiver
import com.ilya.mihailenko.eventreminder.common.reboot.SystemRebootReceiver
import com.ilya.mihailenko.eventreminder.common.reboot.TimeChangedReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BroadcastReceiversProvider {
    @ContributesAndroidInjector
    abstract fun contributesAlarmReceiver(): AlarmReceiver

    @ContributesAndroidInjector
    abstract fun contributesSystemRebootReceiver(): SystemRebootReceiver

    @ContributesAndroidInjector
    abstract fun contributesTimeChangedReceiver(): TimeChangedReceiver
}