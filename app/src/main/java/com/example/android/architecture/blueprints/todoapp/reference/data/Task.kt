package com.example.android.architecture.blueprints.todoapp.reference.data

import com.example.android.architecture.blueprints.todoapp.reference.util.isNotNullNorEmpty
import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String?,
    val description: String?,
    val completed: Boolean = false
) {
  val titleForList =
      if (title.isNotNullNorEmpty()) {
        title
      } else {
        description
      }

  val active = !completed

  val empty = title.isNullOrEmpty() && description.isNullOrEmpty()
}