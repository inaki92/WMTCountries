package com.example.inakilizarraga_walmart_countries.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inakilizarraga_walmart_countries.usecases.CountriesUseCase

class ViewModelFactory(
    private val useCase: CountriesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}