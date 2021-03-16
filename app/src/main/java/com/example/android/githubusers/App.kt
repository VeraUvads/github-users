package com.example.android.githubusers

import com.example.android.githubusers.data.EndpointProvider
import com.example.android.githubusers.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        EndpointProvider.createEndpoint()
    }
}
