package com.example.android.githubusers.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.githubusers.di.ViewModelFactory
import com.example.android.githubusers.di.util.ViewModelKey
import com.example.android.githubusers.feature.user_details.detail.UserDetailInfoViewModel
import com.example.android.githubusers.ui.list.UserListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    internal abstract fun userListViewModel(viewModel: UserListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(com.example.android.githubusers.feature.user_details.detail.UserDetailInfoViewModel::class)]
    internal abstract fun userDetailInfoViewModel(viewModel: com.example.android.githubusers.feature.user_details.detail.UserDetailInfoViewModel): ViewModel
}
