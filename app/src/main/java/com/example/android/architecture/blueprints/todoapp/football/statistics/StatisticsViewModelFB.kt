package com.example.android.architecture.blueprints.todoapp.football.statistics

import android.arch.lifecycle.ViewModel
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewModelFB
import io.reactivex.Observable

class StatisticsViewModelFB(private val actionProcessorHolder: StatisticsActionProcessorHolder)
    : ViewModel() ,MviViewModelFB<StatisticsIntentFB , StatisticsViewStateFB>{
    override fun processIntents(intents: Observable<StatisticsIntentFB>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun states(): Observable<StatisticsViewStateFB> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}