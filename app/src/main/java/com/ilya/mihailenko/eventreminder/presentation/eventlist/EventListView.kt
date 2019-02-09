package com.ilya.mihailenko.eventreminder.presentation.eventlist

import com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter.EventViewItem
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseView


interface EventListView : BaseView {
    fun showEvents(events: MutableList<EventViewItem>)
}
