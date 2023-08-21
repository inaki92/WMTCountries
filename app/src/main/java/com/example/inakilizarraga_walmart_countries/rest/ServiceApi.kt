package com.example.inakilizarraga_walmart_countries.rest

import com.example.inakilizarraga_walmart_countries.model.Country
import com.example.inakilizarraga_walmart_countries.utils.COUNTRY_PATH
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET(COUNTRY_PATH)
    suspend fun getCountries(): Response<List<Country>>
}