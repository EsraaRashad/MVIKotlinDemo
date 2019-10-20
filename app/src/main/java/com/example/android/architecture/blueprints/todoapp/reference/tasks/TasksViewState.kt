package com.example.android.architecture.blueprints.todoapp.reference.tasks

import com.example.android.architecture.blueprints.todoapp.reference.data.Task
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviViewState
import com.example.android.architecture.blueprints.todoapp.reference.tasks.TasksFilterType.ALL_TASKS

data class TasksViewState(
        val isLoading: Boolean,
        val tasksFilterType: TasksFilterType,
        val tasks: List<Task>,
        val error: Throwable?,
        val uiNotification: UiNotification?
) : MviViewState {
  enum class UiNotification {
    TASK_COMPLETE,
    TASK_ACTIVATED,
    COMPLETE_TASKS_CLEARED
  }

  companion object {
    fun idle(): TasksViewState {
      return TasksViewState(
              isLoading = false,
              tasksFilterType = ALL_TASKS,
              tasks = emptyList(),
              error = null,
              uiNotification = null
      )
    }
  }
}
