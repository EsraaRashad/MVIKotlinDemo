package com.example.android.architecture.blueprints.todoapp.football.list

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewStateFB

data class ListViewState(
        val isLoading: Boolean,
        val error: Throwable?
) : MviViewStateFB {
    companion object {
        fun idle(): ListViewState {
            return ListViewState(
                    isLoading = false,
                    error = null
            )
        }
    }
}