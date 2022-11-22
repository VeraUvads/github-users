package com.example.android.githubusers.utils.extensions

import android.content.Context
import com.example.android.githubusers.App
import com.example.android.githubusers.di.component.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> (this.applicationContext as App).appComponent
    }
