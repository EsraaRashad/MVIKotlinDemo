package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.data.model.Round
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewStateFB

data class ListViewState(
        val isLoading: Boolean,
        val name: String,
        val rounds: ArrayList<Round>,
        val error: Throwable?
) : MviViewStateFB {
    companion object {
        fun idle(): ListViewState {
            return ListViewState(
                    isLoading = false,
                    name = "",
                    rounds = ArrayList(),
                    error = null
            )
        }
    }
}