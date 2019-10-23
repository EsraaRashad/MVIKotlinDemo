package com.example.android.architecture.blueprints.todoapp.football.data

import com.example.android.architecture.blueprints.todoapp.football.data.api.ApiService
import com.example.android.architecture.blueprints.todoapp.football.data.model.League
import com.example.android.architecture.blueprints.todoapp.football.list.base.BaseRepository
import io.reactivex.Single
import javax.inject.Inject

class ListRepository @Inject constructor() :BaseRepository() {

    @Inject
    lateinit var apiService: ApiService

    fun getLeague() : Single<League> {
        return apiService.getLeagues()
    }
}