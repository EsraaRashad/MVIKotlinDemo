package com.example.android.architecture.blueprints.todoapp.football.list

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AppInstance : Application() , HasActivityInjector , HasSupportFragmentInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> = fragmentInjector
}