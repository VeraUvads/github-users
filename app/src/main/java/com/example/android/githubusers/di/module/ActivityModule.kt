package com.example.android.githubusers.di.module

import com.example.android.githubusers.MainActivity
import com.example.android.githubusers.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    @PerActivity
    abstract fun mainActivity(): MainActivity
}
