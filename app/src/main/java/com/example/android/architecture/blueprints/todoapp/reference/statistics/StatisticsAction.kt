package com.example.android.architecture.blueprints.todoapp.reference.statistics

import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviAction

sealed class StatisticsAction : MviAction {
  object LoadStatisticsAction : StatisticsAction()
}
