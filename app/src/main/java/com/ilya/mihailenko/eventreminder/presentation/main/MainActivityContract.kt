package com.ilya.mihailenko.eventreminder.presentation.main

import com.ilya.mihailenko.eventreminder.presentation.mvp.BasePresenter
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseView

//TODO
interface MainActivityContract {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View>()
}