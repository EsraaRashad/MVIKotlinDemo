package com.example.android.architecture.blueprints.todoapp.football.list.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.android.architecture.blueprints.todoapp.football.di.helper.Injectable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment: Fragment(), Injectable {
    internal val disposables = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    abstract fun bind()


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}