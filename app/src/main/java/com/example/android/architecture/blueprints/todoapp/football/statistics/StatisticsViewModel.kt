package com.example.android.architecture.blueprints.todoapp.football.statistics

import android.arch.lifecycle.ViewModel
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewModel
import io.reactivex.Observable

class StatisticsViewModel(private val actionProcessorHolder: StatisticsActionProcessorHolder)
    : ViewModel() ,MviViewModel<StatisticsIntentFB , StatisticsViewState>{
    override fun processIntents(intents: Observable<StatisticsIntentFB>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun states(): Observable<StatisticsViewState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}