package com.ilya.mihailenko.eventreminder.navigation

import android.support.v4.app.FragmentActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command


class MainActivityNavigator(activity: FragmentActivity?, containerId: Int) :
    SupportAppNavigator(activity, containerId) {

    override fun applyCommand(command: Command?) {
        super.applyCommand(command)
    }
}