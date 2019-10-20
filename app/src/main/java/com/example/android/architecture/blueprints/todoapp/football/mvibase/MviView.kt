package com.example.android.architecture.blueprints.todoapp.football.mvibase

import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviIntent
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviView
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviViewModel
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviViewState
import io.reactivex.Observable

interface MviView<I : MviIntent, in S : MviViewState> {
    /**
     * Unique [Observable] used by the [MviViewModel]
     * to listen to the [MviView].
     * All the [MviView]'s [MviIntent]s must go through this [Observable].
     */
    fun intents(): Observable<I>

    /**
     * Entry point for the [MviView] to render itself based on a [MviViewState].
     */
    fun render(state: S)
}