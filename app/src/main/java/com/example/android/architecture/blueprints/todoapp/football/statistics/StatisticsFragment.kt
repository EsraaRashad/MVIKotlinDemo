package com.example.android.architecture.blueprints.todoapp.football.statistics


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviView
import io.reactivex.Observable

/**
 * A simple [Fragment] subclass.
 */
class StatisticsFragment : Fragment(), MviView<StatisticsIntentFB, StatisticsViewState> {
    override fun intents(): Observable<StatisticsIntentFB> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(state: StatisticsViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    companion object {
        operator fun invoke(): StatisticsFragment = StatisticsFragment()
    }
}
