package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.data.ListRepository
import com.example.android.architecture.blueprints.todoapp.football.data.model.League
import com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular.BaseSchedulerProviders
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class ListActionProcessorHolder @Inject constructor(private val listRepository: ListRepository
                                                    , private val baseSchedulerProviders: BaseSchedulerProviders){

    private val loadStatisticsProcessor =
            ObservableTransformer<ListAction.LoadListAction, ListResult.LoadListResult> { actions ->
                actions.flatMap {
                    listRepository.getLeague()
                            // Transform one event of a List<Task> to an observable<Task>.
                            .toObservable()
                            .map {
                                 league -> ListResult.LoadListResult.Success(league.name , league.rounds)
                            }
                            .cast(ListResult.LoadListResult::class.java)
                            // Wrap any error into an immutable object and pass it down the stream
                            // without crashing.
                            // Because errors are data and hence, should just be part of the stream.
                            .onErrorReturn(ListResult.LoadListResult::Failure)
                            .subscribeOn(baseSchedulerProviders.io())
                            .observeOn(baseSchedulerProviders.ui())
                            // Emit an InFlight event to notify the subscribers (e.g. the UI) we are
                            // doing work and waiting on a response.
                            // We emit it after observing on the UI thread to allow the event to be emitted
                            // on the current frame and avoid jank.
                            .startWith(ListResult.LoadListResult.InFlight)
                }
            }

    var actionProcessor =
            ObservableTransformer<ListAction, ListResult> { actions ->
                actions.publish { shared ->
                    // Match LoadListResult to loadStatisticsProcessor
                    shared.ofType(ListAction.LoadListAction::class.java).compose(loadStatisticsProcessor)
                            .cast(ListResult::class.java)
                            .mergeWith(
                                    // Error for not implemented actions
                                    shared.filter { v -> v !is ListAction.LoadListAction }
                                            .flatMap { w ->
                                                Observable.error<ListResult>(
                                                        IllegalArgumentException("Unknown Action type: " + w))
                                            })
                }
            }
}