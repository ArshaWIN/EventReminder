package com.ilya.mihailenko.eventreminder.di.module

import com.ilya.mihailenko.eventreminder.di.scopes.PerFragment
import com.ilya.mihailenko.eventreminder.model.interactor.addevent.AddEventInteractor
import com.ilya.mihailenko.eventreminder.model.interactor.addevent.AddEventInteractorImpl
import com.ilya.mihailenko.eventreminder.model.repository.event.EventsRepository
import dagger.Module
import dagger.Provides

@Module
class AddEventModule {
    @Provides
    @PerFragment
    fun provideAddEventInteractor(eventsRepository: EventsRepository): AddEventInteractor =
        AddEventInteractorImpl(eventsRepository)
}