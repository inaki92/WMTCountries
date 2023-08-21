package com.example.inakilizarraga_walmart_countries.di

import android.app.Application

class CountryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Provider.init(applicationContext)
    }
}