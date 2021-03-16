package com.example.android.githubusers.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.githubusers.di.ViewModelFactory
import com.example.android.githubusers.ui.list.UserListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.handh.vseinstrumenti.di.util.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    internal abstract fun userListViewModel(viewModel: UserListViewModel): ViewModel
}
