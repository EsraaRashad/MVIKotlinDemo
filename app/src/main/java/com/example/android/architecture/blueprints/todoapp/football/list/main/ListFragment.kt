package com.example.android.architecture.blueprints.todoapp.football.list.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.football.list.base.BaseFragment
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewFB
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : BaseFragment(), MviViewFB<ListIntent, ListViewState> {

    // Used to manage the data flow lifecycle and avoid memory leak.
    @Inject
    lateinit var viewModel: ListViewModel
    private val refreshIntentPublisher = PublishSubject.create<ListIntent.RefreshIntent>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun intents(): Observable<ListIntent> {
        return Observable.merge(initialIntent(),refreshIntent())
    }

    private fun initialIntent(): Observable<ListIntent.InitialIntent>{
        return Observable.just(ListIntent.InitialIntent)
    }

    private fun refreshIntent() :Observable<ListIntent.RefreshIntent>{
        return RxSwipeRefreshLayout.refreshes(actorsSwipeLayout)
                .map { ListIntent.RefreshIntent(false) }
                .mergeWith(refreshIntentPublisher)
    }

    override fun onResume() {
        super.onResume()

        //for first load data call and on each resume after that to recall get data
        refreshIntentPublisher.onNext(ListIntent.RefreshIntent(false))
    }

    override fun render(state: ListViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bind() {
        // Subscribe to the ViewModel and call render for every emitted state
        disposables.add(viewModel.states().subscribe(this::render))
        viewModel.processIntents(intents())
    }

    companion object {
        operator fun invoke(): ListFragment = ListFragment()
    }
}
