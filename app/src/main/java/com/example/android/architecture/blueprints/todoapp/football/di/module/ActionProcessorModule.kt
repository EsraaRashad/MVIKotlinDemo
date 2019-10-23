package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.data.ListRepository
import com.example.android.architecture.blueprints.todoapp.football.list.main.ListActionProcessorHolder
import dagger.Module
import dagger.Provides

@Module
class ActionProcessorModule {

    @Provides
    fun providesListActionProcessor( repository: ListRepository)= ListActionProcessorHolder(repository)
}