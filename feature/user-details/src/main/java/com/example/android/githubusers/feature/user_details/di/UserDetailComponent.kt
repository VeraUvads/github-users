package com.example.android.githubusers.feature.user_details.di

import com.example.android.githubusers.data_user.datasource.remote.RestApiService
import com.example.android.githubusers.feature.user_details.ui.UserDetailInfoFragment
import dagger.Component

@Component(dependencies = [FeatureDeps::class])
interface UserDetailComponent {
    fun inject(fragment: UserDetailInfoFragment)

    @Component.Builder
    interface Builder {
        fun deps(featureDeps: FeatureDeps): Builder
        fun build(): UserDetailComponent
    }
}

interface FeatureDeps {
    val restApiService: RestApiService
}
