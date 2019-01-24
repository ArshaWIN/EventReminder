package com.ilya.mihailenko.eventreminder.di

import com.ilya.mihailenko.eventreminder.di.module.EventListModule
import com.ilya.mihailenko.eventreminder.di.scopes.PerFragment
import com.ilya.mihailenko.eventreminder.presentation.eventlist.EventListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @PerFragment
    @ContributesAndroidInjector(modules = [EventListModule::class])
    abstract fun provideEventListFragment() : EventListFragment
}