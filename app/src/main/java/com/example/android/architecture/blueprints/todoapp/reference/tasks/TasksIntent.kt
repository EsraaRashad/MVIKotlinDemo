package com.example.android.architecture.blueprints.todoapp.reference.tasks

import com.example.android.architecture.blueprints.todoapp.reference.data.Task
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviIntent

sealed class TasksIntent : MviIntent {
  object InitialIntent : TasksIntent()

  data class RefreshIntent(val forceUpdate: Boolean) : TasksIntent()

  data class ActivateTaskIntent(val task: Task) : TasksIntent()

  data class CompleteTaskIntent(val task: Task) : TasksIntent()

  object ClearCompletedTasksIntent : TasksIntent()

  data class ChangeFilterIntent(val filterType: TasksFilterType) : TasksIntent()
}
