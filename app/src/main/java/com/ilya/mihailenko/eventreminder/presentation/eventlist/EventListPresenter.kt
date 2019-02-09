package com.ilya.mihailenko.eventreminder.presentation.eventlist

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.model.interactor.eventlist.EventListInteractor
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.navigation.Screens
import com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter.EventViewItem
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import com.ilya.mihailenko.eventreminder.utils.ext.listMap
import com.ilya.mihailenko.eventreminder.utils.rx.SubscriberSimple
import com.ilya.mihailenko.eventreminder.utils.rx.SubscriberSimpleJava
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class EventListPresenter @Inject constructor(
    private val router: ExtendedRouter,
    private val eventListInteractor: EventListInteractor
) : BasePresenter<EventListView>() {

    override fun onFirstViewAttach() {
        eventListInteractor.observeEvents()
            .listMap { EventViewItem(it) }
            .map { it.toMutableList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(SubscriberSimpleJava.create { viewState.showEvents(it) })
            .addDisposable()
    }

    fun onBackPressed() {
        router.exit()
    }

    fun onFabClick() {
        router.navigateTo(Screens.AddEvent)
    }
}