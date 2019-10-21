package com.example.android.architecture.blueprints.todoapp.football.list.main

import com.example.android.architecture.blueprints.todoapp.football.mvibase.MviIntentFB

sealed class ListIntent : MviIntentFB {
    object InitialIntent : ListIntent()
}