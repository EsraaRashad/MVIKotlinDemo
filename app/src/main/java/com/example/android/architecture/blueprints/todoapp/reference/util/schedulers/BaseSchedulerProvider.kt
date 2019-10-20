package com.example.android.architecture.blueprints.todoapp.reference.util.schedulers

import io.reactivex.Scheduler

/**
 * Allow providing different types of [Scheduler]s.
 */
interface BaseSchedulerProvider {
  fun computation(): Scheduler

  fun io(): Scheduler

  fun ui(): Scheduler
}
