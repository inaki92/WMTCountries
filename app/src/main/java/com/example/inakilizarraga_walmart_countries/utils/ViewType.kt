package com.example.inakilizarraga_walmart_countries.utils

sealed class ViewType {
    data class Country(val country: com.example.inakilizarraga_walmart_countries.model.Country) : ViewType()
    data class Letter(val letter: String) : ViewType()
}
