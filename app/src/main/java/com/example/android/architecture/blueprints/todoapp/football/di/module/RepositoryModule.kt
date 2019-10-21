package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.list.main.ListRepository
import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviRepositoryFB
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindListRepository(listRepository: ListRepository) : MviRepositoryFB
}