package com.example.inakilizarraga_walmart_countries.utils

sealed class State<out T> {
    object LOADING : State<Nothing>()
    data class SUCCESS<T>(val data: T) : State<T>()
    data class ERROR(val error: Exception) : State<Nothing>()
}
