package com.ilya.mihailenko.eventreminder.ui.adapter

import android.databinding.ViewDataBinding

import com.ilya.mihailenko.eventreminder.ui.adapter.diffutil.ContentComparable
import com.ilya.mihailenko.eventreminder.ui.adapter.diffutil.DiffCalculator

open class DataBindingAdapterDiff<B : ViewDataBinding, V> :
    DataBindingAdapter<B, V>() where  V : ViewItem<B>, V : ContentComparable<V> {

    private val diffCalculator: DiffCalculator<V> = DiffCalculator(this)

    override var items: MutableList<V>
        get() = super.items
        set(value) {
            diffCalculator.updateList(items, value)
        }
}
