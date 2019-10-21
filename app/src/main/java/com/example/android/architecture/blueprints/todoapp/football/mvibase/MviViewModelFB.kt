package com.example.android.architecture.blueprints.todoapp.football.mvibase

import io.reactivex.Observable

interface MviViewModelFB<I : MviIntentFB, S : MviViewStateFB> {
    fun processIntents(intents: Observable<I>)

    fun states(): Observable<S>
}
