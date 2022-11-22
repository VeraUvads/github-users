package com.example.android.githubusers.di.module

import com.example.android.githubusers.data_user.datasource.remote.RestApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(
        gsonConverterFactory: GsonConverterFactory,
        callAdapterFactory: RxJava2CallAdapterFactory
    ): com.example.android.githubusers.data_user.datasource.remote.RestApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
            .create(com.example.android.githubusers.data_user.datasource.remote.RestApiService::class.java)
    }

    @Provides
    fun jsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun callAdapterFactoryFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }
}
