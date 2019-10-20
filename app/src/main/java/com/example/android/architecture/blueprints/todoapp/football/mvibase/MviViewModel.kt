package com.example.android.architecture.blueprints.todoapp.football.mvibase

import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviIntent
import com.example.android.architecture.blueprints.todoapp.reference.mvibase.MviViewState
import io.reactivex.Observable

interface MviViewModel<I : MviIntent, S : MviViewState> {
    fun processIntents(intents: Observable<I>)

    fun states(): Observable<S>
}
