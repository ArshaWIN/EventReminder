package com.ilya.mihailenko.eventreminder.di


import com.ilya.mihailenko.eventreminder.ReminderApp
import com.ilya.mihailenko.eventreminder.di.module.DatabaseModule

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, NavigationModule::class, ActivityBuilder::class, DatabaseModule::class]
)
interface AppComponent : AndroidInjector<ReminderApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ReminderApp>()
}