package com.ilya.mihailenko.eventreminder.presentation.mvp

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    protected fun Disposable.addDisposable() {
        compositeDisposable.add(this)
    }
}