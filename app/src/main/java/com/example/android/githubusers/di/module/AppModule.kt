package com.example.android.githubusers.di.module

import android.app.Application
import android.content.Context
import com.example.android.githubusers.App
import com.example.android.githubusers.data.EndpointProvider
import com.example.android.githubusers.data.RestApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class AppModule {

    companion object {
        const val CONNECTION_TIMEOUT = 20000L
    }

    @Provides
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    fun provideApplication(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideApiService(gson: Gson): RestApiService {
        return Retrofit.Builder()
            .baseUrl(EndpointProvider.apiEndpoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestApiService::class.java)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }
}
