package com.example.android.architecture.blueprints.todoapp.football.mvibase


import io.reactivex.Observable

interface MviViewFB<I : MviIntentFB, in S : MviViewStateFB> {
    /**
     * Unique [Observable] used by the [MviViewModelFB]
     * to listen to the [MviViewFB].
     * All the [MviViewFB]'s [MviIntentFB]s must go through this [Observable].
     */
    fun intents(): Observable<I>

    /**
     * Entry point for the [MviViewFB] to render itself based on a [MviViewStateFB].
     */
    fun render(state: S)
}