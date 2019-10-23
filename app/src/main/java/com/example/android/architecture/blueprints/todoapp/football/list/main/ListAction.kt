package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviActionFB

sealed class ListAction : MviActionFB {
    data class LoadTasksAction(val forceUpdate: Boolean) : ListAction()
    object LoadListAction : ListAction()
}