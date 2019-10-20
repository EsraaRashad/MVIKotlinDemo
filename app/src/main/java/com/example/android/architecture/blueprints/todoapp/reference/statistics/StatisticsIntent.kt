package com.example.android.architecture.blueprints.todoapp.reference.statistics

import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviIntent

sealed class StatisticsIntent : MviIntent {
  object InitialIntent : StatisticsIntent()
}
