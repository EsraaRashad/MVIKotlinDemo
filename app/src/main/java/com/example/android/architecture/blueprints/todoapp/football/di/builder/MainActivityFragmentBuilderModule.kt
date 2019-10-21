package com.example.android.architecture.blueprints.todoapp.football.di.builder

import com.example.android.architecture.blueprints.todoapp.football.list.main.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment() : ListFragment
}