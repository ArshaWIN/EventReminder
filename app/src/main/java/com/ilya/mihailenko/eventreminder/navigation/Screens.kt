package com.ilya.mihailenko.eventreminder.navigation

import com.ilya.mihailenko.eventreminder.presentation.eventlist.EventListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

    object EventList : SupportAppScreen() {
        override fun getFragment() = EventListFragment.newInstanse()
    }
}