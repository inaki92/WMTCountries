package com.example.inakilizarraga_walmart_countries.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.inakilizarraga_walmart_countries.rest.MainRepository
import com.example.inakilizarraga_walmart_countries.rest.MainRepositoryImpl
import com.example.inakilizarraga_walmart_countries.rest.ServiceApi
import com.example.inakilizarraga_walmart_countries.usecases.CountriesUseCase
import com.example.inakilizarraga_walmart_countries.utils.BASE_URL
import com.example.inakilizarraga_walmart_countries.utils.cacheSize
import com.example.inakilizarraga_walmart_countries.viewmodel.ViewModelFactory
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Provider {

    private var appContext: Context? = null

    private val connectivityManager by  lazy {
        appContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    private val serviceApi: ServiceApi by lazy {
        retrofit.create(ServiceApi::class.java)
    }

    private val repository: MainRepository by lazy {
        MainRepositoryImpl(serviceApi)
    }

    private val countryUseCase: CountriesUseCase by lazy {
        CountriesUseCase(repository)
    }

    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(countryUseCase)
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okhttpClient)
            .build()
    }

    private val okhttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val gson by lazy { Gson() }

    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val cache by lazy {
        Cache(appContext?.cacheDir!!, cacheSize)
    }

    fun init(context: Context) {
        appContext = context
    }

    fun destroy() {
        appContext = null
    }

    fun isNetworkAvailable(): Boolean =
        connectivityManager.activeNetwork?.let { network ->
            connectivityManager.getNetworkCapabilities(network)
                ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
        } ?: false
}