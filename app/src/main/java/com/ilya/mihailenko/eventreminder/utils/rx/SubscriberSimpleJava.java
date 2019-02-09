package com.ilya.mihailenko.eventreminder.utils.rx;

import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.DisposableSubscriber;
import timber.log.Timber;

public class SubscriberSimpleJava<T> extends DisposableSubscriber<T> {

    public static <T> SubscriberSimple<T> create() {
        return new SubscriberSimple<>();
    }

    public static <T> SubscriberSimple<T> create(final Consumer<T> onNext) {
        return new SubscriberSimple<T>() {
            @Override
            public void onNext(T t) {
                try {
                    onNext.accept(t);
                } catch (Exception e) {
                    Timber.e(e);
                }
            }
        };
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        Timber.e(t);
    }

    @Override
    public void onComplete() {

    }
}