package com.example.android.architecture.blueprints.todoapp.football.list

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviActionFB

sealed class ListAction : MviActionFB {
    object LoadListAction : ListAction()
}