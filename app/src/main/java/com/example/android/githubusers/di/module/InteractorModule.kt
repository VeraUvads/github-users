package com.example.android.githubusers.di.module

import com.example.android.githubusers.domain.interactor.UserInteractor
import com.example.android.githubusers.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryModule::class])
open class InteractorModule {

    @Provides
    fun getUserInteractor(userRepository: UserRepository): UserInteractor {
        return UserInteractor(userRepository)
    }
}
