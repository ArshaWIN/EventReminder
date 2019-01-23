package com.ilya.mihailenko.eventreminder.presentation.mvp

import com.arellomobile.mvp.MvpPresenter


abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {
}