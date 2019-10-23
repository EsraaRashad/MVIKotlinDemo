package com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

interface BaseSchedulerProviders {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

    fun<T> applySchedulers(): ObservableTransformer<T,T>
}