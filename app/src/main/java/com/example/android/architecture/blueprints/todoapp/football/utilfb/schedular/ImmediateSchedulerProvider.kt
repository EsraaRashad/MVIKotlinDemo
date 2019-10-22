package com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Implementation of the [BaseSchedulerProvider] making all [Scheduler]s immediate.
 */
class ImmediateSchedulerProvider : BaseSchedulerProviders {
    override fun computation(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun ui(): Scheduler = Schedulers.trampoline()
}