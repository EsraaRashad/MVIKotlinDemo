package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviAction

sealed class StatisticsAction : MviAction {
    object LoadStatisticsAction : StatisticsAction()
}