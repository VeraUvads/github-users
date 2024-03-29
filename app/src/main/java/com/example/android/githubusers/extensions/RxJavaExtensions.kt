package com.example.android.githubusers.extensions

import com.example.android.githubusers.utils.Response
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.convert(block: (Response<T>) -> Unit): Disposable {
    return doOnSubscribe {
        block.invoke(Response.loading())
    }.subscribe(
        { value ->
            block.invoke(Response.success(value))
        },
        { throwable ->
            block.invoke(Response.error(throwable))
        }
    )
}

fun <T> Flowable<T>.convert(block: (Response<T>) -> Unit): Disposable {
    return doOnSubscribe {
        block.invoke(Response.Loading())
    }.subscribe(
        { value ->
            block.invoke(Response.Success(value))
        },
        { throwable ->
            block.invoke(Response.error(throwable))
        }
    )
}

fun <T> Observable<T>.convert(block: (Response<T>) -> Unit): Disposable {
    return doOnSubscribe {
        block.invoke(Response.loading())
    }.subscribe(
        { value ->
            block.invoke(Response.success(value))
        },
        { throwable ->
            block.invoke(Response.error(throwable))
        }
    )
}

fun <T> asyncSingle(): SingleTransformer<T, T> {
    return SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun asyncCompletable(): CompletableTransformer {
    return CompletableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> asyncFlowable(): FlowableTransformer<T, T> {
    return FlowableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> asyncObservable(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> Flowable<T>.async(): Flowable<T> = compose(asyncFlowable())

fun <T> Single<T>.async(): Single<T> = compose(asyncSingle())

fun Completable.async(): Completable = compose(asyncCompletable())

fun <T> Observable<T>.async(): Observable<T> = compose(asyncObservable())
