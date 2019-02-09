package com.ilya.mihailenko.eventreminder.ui.adapter.diffutil

import android.support.annotation.UiThread
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.ilya.mihailenko.eventreminder.utils.ext.unsubscribeSafe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DiffCalculator<T : ContentComparable<T>>(private val adapter: RecyclerView.Adapter<*>) {

    private lateinit var oldItems: MutableList<T>
    private lateinit var newItems: MutableList<T>

    private var updateListSubscription: Disposable? = null

    @UiThread
    @JvmOverloads
    fun updateList(
        oldItems: MutableList<T>,
        newItems: MutableList<T>,
        detectMoves: Boolean = true
    ) {
        updateListSubscription.unsubscribeSafe()

        this.oldItems = oldItems
        this.newItems = newItems

        updateListSubscription =
                Single.fromCallable { calculateDiff(detectMoves) }
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ dispatchUpdates(it) }, { Timber.e(it) })
    }

    private fun calculateDiff(detectMoves: Boolean): DiffUtil.DiffResult {
        val diffCallback = DiffUtilListCallback(
            ArrayList(oldItems),
            ArrayList(newItems)
        )
        return DiffUtil.calculateDiff(diffCallback, detectMoves)
    }

    private fun dispatchUpdates(diffResult: DiffUtil.DiffResult) {
        oldItems.clear()
        oldItems.addAll(newItems)
        diffResult.dispatchUpdatesTo(adapter)
    }
}
