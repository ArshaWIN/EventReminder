package com.ilya.mihailenko.eventreminder.di.module

import com.ilya.mihailenko.eventreminder.di.scopes.PerFragment
import com.ilya.mihailenko.eventreminder.model.interactor.eventlist.EventListInteractor
import com.ilya.mihailenko.eventreminder.model.interactor.eventlist.EventListInteractorImpl
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import dagger.Module
import dagger.Provides


@Module
class EventListModule {

    @PerFragment
    @Provides
    fun provideEventListInteractor(eventsRepository: EventsRepository): EventListInteractor =
        EventListInteractorImpl(eventsRepository)

}