package com.ilya.mihailenko.eventreminder.di.module.common

import com.ilya.mihailenko.eventreminder.di.module.MainActivityModule
import com.ilya.mihailenko.eventreminder.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.ilya.mihailenko.eventreminder.presentation.main.MainActivity


@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

}
