package com.ilya.mihailenko.eventreminder.presentation.eventlist

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.model.interactor.eventlist.EventListInteractor
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.navigation.Screens
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class EventListPresenter @Inject constructor(
    private val router: ExtendedRouter,
    private val eventListInteractor: EventListInteractor
) : BasePresenter<EventListView>() {

    override fun onFirstViewAttach() {
        eventListInteractor.observeEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ events -> Timber.d("Yeah") })
            .addDisposable()
    }

    fun onBackPressed() {
        router.exit()
    }

    fun onFabClick() {
        router.navigateTo(Screens.AddEvent)
    }
}