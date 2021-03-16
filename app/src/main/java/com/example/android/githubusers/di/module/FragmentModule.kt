package com.example.android.githubusers.di.module

import com.example.android.githubusers.di.scope.PerFragment
import com.example.android.githubusers.ui.detail.UserDetailInfoFragment
import com.example.android.githubusers.ui.list.UserListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    @PerFragment
    abstract fun userListFragment(): UserListFragment

    @ContributesAndroidInjector
    @PerFragment
    abstract fun userDetailsInfoFragment(): UserDetailInfoFragment
}
