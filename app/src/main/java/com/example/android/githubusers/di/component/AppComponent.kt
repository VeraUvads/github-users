package com.example.android.githubusers.di.component

import com.example.android.githubusers.App
import com.example.android.githubusers.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        InteractorModule::class,
        ViewModelModule::class,
        FragmentModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: App): AppComponent
    }
}
