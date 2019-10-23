package com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Implementation of the [BaseSchedulerProvider] making all [Scheduler]s immediate.
 */
class ImmediateSchedulerProvider @Inject constructor()
    : BaseSchedulerProviders {
    override fun computation(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun<T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer{
            upstream ->
            upstream.subscribeOn(io())
                    .observeOn(ui())
        }
    }
}