package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviIntentFB

sealed class StatisticsIntentFB : MviIntentFB {
    object InitialIntentFB : StatisticsIntentFB()
}