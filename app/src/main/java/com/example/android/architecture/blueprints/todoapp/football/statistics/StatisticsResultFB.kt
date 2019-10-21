package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviResultFB

sealed class StatisticsResultFB : MviResultFB {
    sealed class LoadStatisticsResultFB : StatisticsResultFB(){
        data class Success (val activeCount: Int, val completedCount: Int) : LoadStatisticsResultFB()
        data class Failure (val error : Throwable) : LoadStatisticsResultFB()
        object InFlight : LoadStatisticsResultFB()
    }
}