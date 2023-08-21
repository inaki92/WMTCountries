package com.example.inakilizarraga_walmart_countries.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("capital")
    val capital: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("currency")
    val currency: Currency? = null,
    @SerializedName("demonym")
    val demonym: String? = null,
    @SerializedName("flag")
    val flag: String? = null,
    @SerializedName("language")
    val language: Language? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("region")
    val region: String? = null
)