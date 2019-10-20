package com.example.android.architecture.blueprints.todoapp.reference.util

fun String?.isNullOrEmpty() = this == null || this.isEmpty()
fun String?.isNotNullNorEmpty() = !this.isNullOrEmpty()