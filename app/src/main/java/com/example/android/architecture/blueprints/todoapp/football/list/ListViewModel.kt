package com.example.android.architecture.blueprints.todoapp.football.list

import android.arch.lifecycle.ViewModel
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviViewModelFB
import com.example.android.architecture.blueprints.todoapp.football.utilfb.notOfType
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

class ListViewModel(private val actionProcessorHolder: ListActionProcessorHolder)
    : ViewModel() ,MviViewModelFB<ListIntent , ListViewState>{

    private val intentsSubject: PublishSubject<ListIntent> = PublishSubject.create()
    private val statesObservable: Observable<ListViewState> = compose()
    private val disposables = CompositeDisposable()

    /**
     * take only the first ever InitialIntent and all intents of other types
     * to avoid reloading data on config changes
     */
    private val intentFilter: ObservableTransformer<ListIntent, ListIntent>
        get() = ObservableTransformer { intents ->
            intents.publish { shared ->
                Observable.merge<ListIntent>(
                        shared.ofType(ListIntent.InitialIntent::class.java).take(1),
                        shared.notOfType(ListIntent.InitialIntent::class.java)
                )
            }
        }
    override fun processIntents(intents: Observable<ListIntent>) {
        disposables.add(intents.subscribe(intentsSubject::onNext))
    }

    override fun states(): Observable<ListViewState> = statesObservable

    /**
     * Compose all components to create the stream logic
     */
    private fun compose(): Observable<ListViewState> {
        return intentsSubject
                .compose<ListIntent>(intentFilter)
                .map<ListAction>(this::actionFromIntent)
                .compose(actionProcessorHolder.actionProcessor)
                // Cache each state and pass it to the reducer to create a new state from
                // the previous cached one and the latest Result emitted from the action processor.
                // The Scan operator is used here for the caching.
                .scan(ListViewState.idle(), reducer)
                // When a reducer just emits previousState, there's no reason to call render. In fact,
                // redrawing the UI in cases like this can cause jank (e.g. messing up snackbar animations
                // by showing the same snackbar twice in rapid succession).
                .distinctUntilChanged()
                // Emit the last one event of the stream on subscription.
                // Useful when a View rebinds to the ViewModel after rotation.
                .replay(1)
                // Create the stream on creation without waiting for anyone to subscribe
                // This allows the stream to stay alive even when the UI disconnects and
                // match the stream's lifecycle to the ViewModel's one.
                .autoConnect(0)
    }

    /**
     * Translate an [MviIntentFB] to an [MviActionFB].
     * Used to decouple the UI and the business logic to allow easy testings and reusability.
     */
    private fun actionFromIntent(intent: ListIntent): ListAction {
        return when (intent) {
            is ListIntent.InitialIntent -> ListAction.LoadListAction
        }
    }

    override fun onCleared() {
        disposables.dispose()
    }

    companion object {
        /**
         * The Reducer is where [MviViewStateFB], that the [MviViewFB] will use to
         * render itself, are created.
         * It takes the last cached [MviViewStateFB], the latest [MviResultFB] and
         * creates a new [MviViewStateFB] by only updating the related fields.
         * This is basically like a big switch statement of all possible types for the [MviResultFB]
         */
        private val reducer = BiFunction { previousState: ListViewState, result: ListResult ->
            when (result) {
                is ListResult.LoadListResult -> when (result) {
                    is ListResult.LoadListResult.Success ->
                        previousState.copy(
                                isLoading = false
                        )
                    is ListResult.LoadListResult.Failure -> previousState.copy(isLoading = false, error = result.error)
                    is ListResult.LoadListResult.InFlight -> previousState.copy(isLoading = true)
                }
            }
        }
    }
}