package com.ilya.mihailenko.eventreminder.di


import com.ilya.mihailenko.eventreminder.ReminderApp

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class]
)
interface AppComponent : AndroidInjector<ReminderApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ReminderApp>()
}