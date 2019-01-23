package com.ilya.mihailenko.eventreminder.di

import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    private val cicerone: Cicerone<ExtendedRouter> = Cicerone.create(ExtendedRouter())

    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideExtendedRouter(): ExtendedRouter = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(): NavigatorHolder = cicerone.navigatorHolder

}