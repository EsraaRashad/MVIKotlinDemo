package com.example.android.architecture.blueprints.todoapp.football.statistics

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewStateFB

class StatisticsViewStateFB(
        val isLoading: Boolean,
        val error: Throwable?
) : MviViewStateFB {
    companion object {
        fun idle(): StatisticsViewStateFB {
            return StatisticsViewStateFB(
                    isLoading = false,
                    error = null
            )
        }
    }
}