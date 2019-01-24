package com.ilya.mihailenko.eventreminder.di

import com.ilya.mihailenko.eventreminder.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.ilya.mihailenko.eventreminder.presentation.main.MainActivity


@Module
internal abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

}
