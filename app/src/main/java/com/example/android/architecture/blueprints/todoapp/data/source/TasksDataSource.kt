/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.data.source

import com.example.android.architecture.blueprints.todoapp.data.Task

import io.reactivex.Completable
import io.reactivex.Single

/**
 * Main entry point for accessing tasks data.
 *
 *
 */
interface TasksDataSource {
  fun getTasks(forceUpdate: Boolean): Single<List<Task>> {
    if (forceUpdate) refreshTasks()
    return getTasks()
  }

  fun getTasks(): Single<List<Task>>

  fun getTask(taskId: String): Single<Task>

  fun saveTask(task: Task): Completable

  fun completeTask(task: Task): Completable

  fun completeTask(taskId: String): Completable

  fun activateTask(task: Task): Completable

  fun activateTask(taskId: String): Completable

  fun clearCompletedTasks(): Completable

  fun refreshTasks()

  fun deleteAllTasks()

  fun deleteTask(taskId: String): Completable
}
