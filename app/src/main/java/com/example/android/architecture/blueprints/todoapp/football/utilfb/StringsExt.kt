package com.example.android.architecture.blueprints.todoapp.football.utilfb

fun String?.isNullOrEmpty() = this == null || this.isEmpty()
fun String?.isNotNullNorEmpty() = !this.isNullOrEmpty()