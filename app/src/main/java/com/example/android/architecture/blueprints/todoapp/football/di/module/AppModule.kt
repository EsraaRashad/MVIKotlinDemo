package com.example.android.architecture.blueprints.todoapp.football.di.module

import dagger.Module

@Module(includes = [ViewModelModule::class, RepositoryModule::class, NetworkModule::class])
class AppModule {
}