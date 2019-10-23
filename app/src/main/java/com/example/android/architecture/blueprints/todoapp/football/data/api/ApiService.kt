package com.example.android.architecture.blueprints.todoapp.football.data.api

import com.example.android.architecture.blueprints.todoapp.football.data.model.League
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("openfootball/football.json/master/2015-16/en.1.json")
    fun getLeagues(): Single<League>
}