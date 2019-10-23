package com.example.android.architecture.blueprints.todoapp.football.di.component

import android.app.Application
import android.content.Context
import com.example.android.architecture.blueprints.todoapp.football.di.module.ActivityModule
import com.example.android.architecture.blueprints.todoapp.football.di.module.AppModule
import com.example.android.architecture.blueprints.todoapp.football.di.module.NetworkModule
import com.example.android.architecture.blueprints.todoapp.football.list.AppInstance
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context) : Builder

        fun build(): AppComponent
    }

    fun inject(appInstance: AppInstance)
}