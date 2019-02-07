package com.ilya.mihailenko.eventreminder.di

import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.di.scopes.PerActivity
import com.ilya.mihailenko.eventreminder.model.data.database.EventDao
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepositoryImpl
import com.ilya.mihailenko.eventreminder.navigation.MainActivityNavigator
import com.ilya.mihailenko.eventreminder.presentation.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideMainActivityNavigator(mainActivity: MainActivity): MainActivityNavigator =
        MainActivityNavigator(mainActivity, R.id.fragmentContainer)

    @Provides
    @PerActivity
    fun provideEventRepository(
        eventDao: EventDao
    ): EventsRepository {
        return EventsRepositoryImpl(eventDao)
    }

}
