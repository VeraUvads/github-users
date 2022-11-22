package com.example.android.githubusers.feature.user_details.di

object UserDetailContentHolder {

    val userDetailComponent = UserDetailComponent.builder().deps(FeatureDepsProvider.deps).build() // ??
}