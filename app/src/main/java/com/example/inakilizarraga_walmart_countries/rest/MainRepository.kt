package com.example.inakilizarraga_walmart_countries.rest

import com.example.inakilizarraga_walmart_countries.model.Country
import retrofit2.Response

interface MainRepository {
    suspend fun retrieveCountries(): Response<List<Country>>
}

class MainRepositoryImpl(
    private val api: ServiceApi
) : MainRepository {
    override suspend fun retrieveCountries(): Response<List<Country>> = api.getCountries()
}