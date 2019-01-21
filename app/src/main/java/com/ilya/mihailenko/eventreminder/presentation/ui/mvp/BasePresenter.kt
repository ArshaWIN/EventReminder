package com.ilya.mihailenko.eventreminder.presentation.ui.mvp

import com.arellomobile.mvp.MvpPresenter


abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {
}