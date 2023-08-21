package com.example.inakilizarraga_walmart_countries.utils

import com.example.inakilizarraga_walmart_countries.di.Provider
import retrofit2.Response

/**
 * This helper function makes the network call generic so it can be used by any component
 * Allowing us to have more scalability
 */
suspend fun <T> makeNetworkConnection(
    request: suspend () -> Response<T>,
    success: suspend (State.SUCCESS<T>) -> Unit,
    error: suspend (State.ERROR) -> Unit
) {
    try {
        if (Provider.isNetworkAvailable()) {
            val response = request.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    success(State.SUCCESS(it))
                } ?: throw NullBodyException()
            } else {
                throw FailResponseException(response.errorBody()?.string())
            }
        } else {
            throw NoNetworkAvailable()
        }
    } catch (e: Exception) {
        error(State.ERROR(e))
    }
}