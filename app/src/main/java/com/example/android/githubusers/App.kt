package com.example.android.githubusers

import android.app.Application
import com.example.android.githubusers.di.component.AppComponent
import com.example.android.githubusers.di.component.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
