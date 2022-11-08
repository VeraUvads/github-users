package com.example.android.githubusers.di.util

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)