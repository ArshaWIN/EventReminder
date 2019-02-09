package com.ilya.mihailenko.eventreminder.utils.ext

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.Disposable


inline fun <T, R> Single<List<T>>.listMap(crossinline mapper: (T) -> R): Single<List<R>> =
    map { it.map(mapper) }

inline fun <T, R> Flowable<List<T>>.listMap(crossinline mapper: (T) -> R): Flowable<List<R>> =
    map { it.map(mapper) }

fun <T : Any> Flowable<List<T?>>.filterNotNull(): Flowable<List<T>> =
    map { it.filterNotNull() }

inline fun <T> Flowable<List<T>>.filterList(crossinline predicate: (T) -> Boolean): Flowable<List<T>> =
    map { it.filter(predicate) }


inline fun <T> Single<List<T>>.filterList(crossinline predicate: (T) -> Boolean): Single<List<T>> =
    map { it.filter(predicate) }

fun Disposable?.unsubscribeSafe() {
    if (this?.isDisposed == false) {
        this.dispose()
    }
}