package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviResultFB

sealed class ListResult : MviResultFB {
    sealed class LoadListResult : ListResult(){
        data class Success (val activeCount: Int, val completedCount: Int) : LoadListResult()
        data class Failure (val error : Throwable) : LoadListResult()
        object InFlight : LoadListResult()
    }
}