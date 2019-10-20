package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviIntent

sealed class StatisticsIntentFB : MviIntent {
    object InitialIntent : StatisticsIntentFB()
}