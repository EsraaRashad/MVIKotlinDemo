package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular.BaseSchedulerProviders
import com.example.android.architecture.blueprints.todoapp.football.utilfb.schedular.ImmediateSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RepositoryModule::class, NetworkModule::class])
class AppModule {
    @Provides
    @Singleton
    fun providesImmediateSchedulerProvider(schedulerProvider: ImmediateSchedulerProvider):BaseSchedulerProviders =schedulerProvider
}