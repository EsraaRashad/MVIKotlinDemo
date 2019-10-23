package com.example.android.architecture.blueprints.todoapp.football.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.architecture.blueprints.todoapp.football.di.helper.ViewModelKey
import com.example.android.architecture.blueprints.todoapp.football.list.base.ViewModelFactory
import com.example.android.architecture.blueprints.todoapp.football.list.main.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindHomeViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory

}