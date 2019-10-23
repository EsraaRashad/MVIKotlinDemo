package com.example.android.architecture.blueprints.todoapp.football.di.component

import android.app.Application
import android.content.Context
import com.example.android.architecture.blueprints.todoapp.football.di.builder.MainActivityFragmentBuilderModule
import com.example.android.architecture.blueprints.todoapp.football.di.module.*
import com.example.android.architecture.blueprints.todoapp.football.list.AppInstance
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    ActivityModule::class,
    MainActivityFragmentBuilderModule::class,
    RepositoryModule::class,
    ActionProcessorModule::class,
    NetworkModule::class])

interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(appInstance: AppInstance)
}