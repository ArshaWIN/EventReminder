package com.ilya.mihailenko.eventreminder.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.navigation.Screens
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val router: ExtendedRouter
) : BasePresenter<MainView>() {

    fun go() {
        router.navigateTo(Screens.EventList)
    }

}