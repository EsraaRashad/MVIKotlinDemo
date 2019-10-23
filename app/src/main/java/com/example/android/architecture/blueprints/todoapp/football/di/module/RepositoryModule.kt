package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.data.ListRepository
import com.example.android.architecture.blueprints.todoapp.football.list.base.BaseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindListRepository(listRepository: ListRepository) : BaseRepository
}