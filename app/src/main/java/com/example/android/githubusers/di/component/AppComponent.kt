package com.example.android.githubusers.di.component

import com.example.android.githubusers.MainActivity
import com.example.android.githubusers.di.module.NetworkModule
import com.example.android.githubusers.di.module.RepositoryModule
import com.example.android.githubusers.di.module.ViewModelModule
import com.example.android.githubusers.feature.user_details.detail.UserDetailInfoFragment
import com.example.android.githubusers.feature.user_details.di.FeatureDeps
import com.example.android.githubusers.feature.user_details.di.UserDetailComponent
import com.example.android.githubusers.ui.list.UserListFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        UserDetailComponent::class,
    ]
)
@Singleton
interface AppComponent : FeatureDeps {
    fun injectMainActivity(mainActivity: MainActivity)
    fun inject(userListFragment: UserListFragment)
}
