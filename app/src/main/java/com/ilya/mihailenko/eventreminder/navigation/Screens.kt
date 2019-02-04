package com.ilya.mihailenko.eventreminder.navigation

import com.ilya.mihailenko.eventreminder.presentation.addevent.AddEventFragment
import com.ilya.mihailenko.eventreminder.presentation.eventlist.EventListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

    object EventList : SupportAppScreen() {
        override fun getFragment() = EventListFragment.newInstance()
    }

    object AddEvent : SupportAppScreen() {
        override fun getFragment() = AddEventFragment.newInstance()
    }
}