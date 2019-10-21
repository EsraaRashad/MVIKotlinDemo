package com.example.android.architecture.blueprints.todoapp.football.statistics


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewFB
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * A simple [Fragment] subclass.
 */
class StatisticsFragment : Fragment(), MviViewFB<StatisticsIntentFB, StatisticsViewStateFB> {
    private lateinit var statisticsTV: TextView
    // Used to manage the data flow lifecycle and avoid memory leak.
    private val disposables: CompositeDisposable = CompositeDisposable()
//    private val viewModel: StatisticsViewModelFB by lazy(LazyThreadSafetyMode.NONE) {
//        ViewModelProviders
//                .of(this, ToDoViewModelFactory.getInstance(context!!))
//                .get(StatisticsViewModelFB::class.java)
//    }
    override fun intents(): Observable<StatisticsIntentFB> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(stateFB: StatisticsViewStateFB) {
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
