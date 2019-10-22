package com.example.android.architecture.blueprints.todoapp.football.list.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.football.list.base.BaseFragment
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewFB
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : BaseFragment(), MviViewFB<ListIntent, ListViewState> {
    private lateinit var statisticsTV: TextView
    // Used to manage the data flow lifecycle and avoid memory leak.
    private val disposables: CompositeDisposable = CompositeDisposable()
//    private val viewModel: ListViewModel by lazy(LazyThreadSafetyMode.NONE) {
//        ViewModelProviders
//                .of(this, ToDoViewModelFactory.getInstance(context!!))
//                .get(ListViewModel::class.java)
//    }
    override fun intents(): Observable<ListIntent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(state: ListViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    companion object {
        operator fun invoke(): ListFragment = ListFragment()
    }
}
