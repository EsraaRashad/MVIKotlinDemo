package com.example.android.architecture.blueprints.todoapp.football.list.main

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class ListActionProcessorHolder {

    private val loadStatisticsProcessor =
            ObservableTransformer<ListAction.LoadListAction, ListResult.LoadListResult> { actions ->
                actions.flatMap {
                    tasksRepository.getTasks()
                            // Transform one event of a List<Task> to an observable<Task>.
                            .flatMapIterable()
                            // Count all active and completed tasks and wrap the result into a Pair.
                            .publish<ListResult.LoadListResult.Success> { shared ->
                                Single.zip<Int, Int, ListResult.LoadListResult.Success>(
                                        shared.filter(Task::active).count().map(Long::toInt),
                                        shared.filter(Task::completed).count().map(Long::toInt),
                                        BiFunction { activeCount, completedCount ->
                                            ListResult.LoadListResult.Success(activeCount, completedCount)
                                        }
                                ).toObservable()
                            }
                            .cast(ListResult.LoadListResult::class.java)
                            // Wrap any error into an immutable object and pass it down the stream
                            // without crashing.
                            // Because errors are data and hence, should just be part of the stream.
                            .onErrorReturn(ListResult.LoadListResult::Failure)
                            .subscribeOn(schedulerProvider.io())
                            .observeOn(schedulerProvider.ui())
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