package com.ilya.mihailenko.eventreminder.presentation.ui.main

import com.ilya.mihailenko.eventreminder.presentation.ui.mvp.BasePresenter
import com.ilya.mihailenko.eventreminder.presentation.ui.mvp.BaseView

//TODO
interface MainActivityContract {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View>()
}