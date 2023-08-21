package com.example.inakilizarraga_walmart_countries.usecases

import com.example.inakilizarraga_walmart_countries.model.Country
import com.example.inakilizarraga_walmart_countries.rest.MainRepository
import com.example.inakilizarraga_walmart_countries.utils.State
import com.example.inakilizarraga_walmart_countries.utils.makeNetworkConnection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountriesUseCase(
    private val repository: MainRepository
) {

    operator fun invoke(): Flow<State<List<Country>>> = flow {
        makeNetworkConnection(
            request = { repository.retrieveCountries() },
            success = { emit(it) },
            error = { emit(it) }
        )
    }
}