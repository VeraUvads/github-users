package com.example.android.githubusers.utils.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.githubusers.utils.extensions.async
import com.example.android.githubusers.utils.extensions.convert
import com.example.android.githubusers.utils.network.Response
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected fun <T> Single<T>.execute(resultLiveData: MutableLiveData<Response<T>>): Disposable {
        return async()
            .convert {
                resultLiveData.postValue(it)
            }
            .autoDispose()
    }

    protected fun <T> Flowable<T>.execute(resultLiveData: MutableLiveData<Response<T>>): Disposable {
        return async()
            .convert {
                resultLiveData.postValue(it)
            }
            .autoDispose()
    }

    protected fun <T> Single<T>.execute(
        block: (T) -> Unit,
        errorBlock: (Throwable) -> Unit
    ): Disposable {
        return async()
            .subscribe(
                {
                    block.invoke(it)
                },
                {
                    errorBlock.invoke(it)
                }
            ).autoDispose()
    }

    private fun Disposable.autoDispose(): Disposable {
        compositeDisposable.add(this)
        return this
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
