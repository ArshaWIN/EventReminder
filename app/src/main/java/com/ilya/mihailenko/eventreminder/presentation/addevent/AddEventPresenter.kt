package com.ilya.mihailenko.eventreminder.presentation.addevent

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.model.interactor.addevent.AddEventInteractor
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@InjectViewState
class AddEventPresenter @Inject constructor(
    private val router: ExtendedRouter,
    private val addEventInteractor: AddEventInteractor
) : BasePresenter<AddEventView>() {

    fun onBackPressed() {
        router.exit()
    }

    fun onSaveClick(
        eventName: String,
        eventDescription: String
    ) {
        val event = Event(
            name = eventName,
            description = eventDescription,
            createdAt = Date(System.currentTimeMillis())
        )
        addEventInteractor.addEvent(event)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ router.exit() }, { Timber.e(it) })
            .addDisposable()
    }
}