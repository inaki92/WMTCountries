package com.example.inakilizarraga_walmart_countries.model


import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("symbol")
    val symbol: String? = null
)