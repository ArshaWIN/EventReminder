package com.ilya.mihailenko.eventreminder.ui.adapter.diffutil

interface ContentComparable<T : ContentComparable<T>> {
    fun areContentsTheSame(another: T): Boolean

    fun areItemsTheSame(another: T): Boolean
}
