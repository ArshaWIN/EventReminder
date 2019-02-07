package com.ilya.mihailenko.eventreminder.model.interactor.eventlist

import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Flowable


interface EventListInteractor {
    fun observeEvents(): Flowable<List<Event>>
}