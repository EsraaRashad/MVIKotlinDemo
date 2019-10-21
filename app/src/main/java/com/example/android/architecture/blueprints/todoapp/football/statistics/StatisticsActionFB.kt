package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviActionFB

sealed class StatisticsActionFB : MviActionFB {
    object LoadStatisticsActionFB : StatisticsActionFB()
}