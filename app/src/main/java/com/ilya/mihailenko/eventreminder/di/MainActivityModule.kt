package com.ilya.mihailenko.eventreminder.di

import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.di.scopes.PerActivity
import com.ilya.mihailenko.eventreminder.navigation.MainActivityNavigator
import com.ilya.mihailenko.eventreminder.presentation.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideMainActivityNavigator(mainActivity: MainActivity): MainActivityNavigator =
        MainActivityNavigator(mainActivity, R.id.fragmentContainer)
}
