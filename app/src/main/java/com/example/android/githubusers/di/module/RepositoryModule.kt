package com.example.android.githubusers.di.module

import com.example.android.githubusers.domain.repository.UserRepository
import com.example.android.githubusers.domain.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

//    @Provides
//    fun provideUserRepository(restApiService: RestApiService): UserRepository{
//        return UserRepositoryImpl(restApiService)
//    }

    @Binds
    fun userRepositoryImpl_to_userRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}