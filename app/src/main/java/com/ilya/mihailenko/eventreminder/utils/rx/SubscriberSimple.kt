package com.ilya.mihailenko.eventreminder.utils.rx

import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.subscribers.DisposableSubscriber
import timber.log.Timber


open class SubscriberSimple<T> : DisposableSubscriber<T>() {


    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
        Timber.e(e, "Error")
    }

    override fun onComplete() {
    }


    companion object {

        fun <T> create(): SubscriberSimple<T> {
            return SubscriberSimple()
        }

        fun <T> create(onNext: Consumer<T>): SubscriberSimple<T> {
            return object : SubscriberSimple<T>() {
                override fun onNext(t: T) {
                    onNext.accept(t)
                }
            }
        }

        fun <T> createWithComplete(onComplete: Action): SubscriberSimple<T> {
            return object : SubscriberSimple<T>() {
                override fun onComplete() {
                    onComplete.run()
                }
            }
        }

        fun <T> handleError(onError: Consumer<Throwable>): SubscriberSimple<T> {
            return object : SubscriberSimple<T>() {
                override fun onError(e: Throwable?) {
                    onError.run { e }
                }
            }
        }
    }
}