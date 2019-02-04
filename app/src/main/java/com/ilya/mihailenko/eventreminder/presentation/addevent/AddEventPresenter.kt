package com.ilya.mihailenko.eventreminder.presentation.addevent

import com.arellomobile.mvp.InjectViewState
import com.ilya.mihailenko.eventreminder.navigation.ExtendedRouter
import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import javax.inject.Inject

@InjectViewState
class AddEventPresenter @Inject constructor(
    val router: ExtendedRouter
) : BasePresenter<AddEventView>() {

    fun onBackPressed() {
        router.exit()
    }
}