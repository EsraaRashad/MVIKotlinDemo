package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviResultFB

sealed class ListResult : MviResultFB {
    sealed class LoadListResult : ListResult(){
        data class Success (val name: String) : LoadListResult()
        data class Failure (val error : Throwable) : LoadListResult()
        object InFlight : LoadListResult()
    }
}