package com.ilya.mihailenko.eventreminder.di

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Singleton
    @Binds
    @AppContext
    abstract fun provideContext(application: Application): Context

}
