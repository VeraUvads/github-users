package com.example.android.githubusers.di.module

import com.example.android.githubusers.data.repository.UserRepositoryImpl
import com.example.android.githubusers.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun userRepository(repository: UserRepositoryImpl): UserRepository
}
