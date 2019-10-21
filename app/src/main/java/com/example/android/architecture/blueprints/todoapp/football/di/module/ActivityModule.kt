package com.example.android.architecture.blueprints.todoapp.football.di.module

import com.example.android.architecture.blueprints.todoapp.football.di.builder.MainActivityFragmentBuilderModule
import com.example.android.architecture.blueprints.todoapp.football.list.main.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): ListActivity
}