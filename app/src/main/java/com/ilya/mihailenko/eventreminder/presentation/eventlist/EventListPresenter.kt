package com.ilya.mihailenko.eventreminder.presentation.eventlist

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import javax.inject.Inject

@InjectViewState
class EventListPresenter @Inject constructor(
    val router: ExtendedRouter
) : BasePresenter<EventListView>() {

    fun onBackPressed() {
        router.exit()
    }
}