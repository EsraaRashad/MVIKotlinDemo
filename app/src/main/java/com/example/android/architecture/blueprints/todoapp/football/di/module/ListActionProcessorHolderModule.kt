package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.list.main.ListActionProcessorHolder
import com.example.android.architecture.blueprints.todoapp.football.mvibase.ListActionProcessorHolderFB
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ListActionProcessorHolderModule {
    @Binds
    @Singleton
    abstract fun bindListActionProcessorHolder(listActionProcessorHolder: ListActionProcessorHolder) : ListActionProcessorHolderFB
}