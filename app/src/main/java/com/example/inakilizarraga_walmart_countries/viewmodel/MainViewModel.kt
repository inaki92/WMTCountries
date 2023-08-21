package com.example.inakilizarraga_walmart_countries.viewmodel

import com.example.inakilizarraga_walmart_countries.model.Country
import com.example.inakilizarraga_walmart_countries.usecases.CountriesUseCase
import com.example.inakilizarraga_walmart_countries.utils.BaseViewModel
import com.example.inakilizarraga_walmart_countries.utils.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val countryUseCase: CountriesUseCase
) : BaseViewModel() {

    private val _countries: MutableStateFlow<State<List<Country>>> = MutableStateFlow(State.LOADING)
    val countries: StateFlow<State<List<Country>>> get() = _countries

    init {
        getCountries()
    }

    fun fetchCountries() {
        getCountries()
    }

    private fun getCountries() {
        safeViewModelScope.launch {
            countryUseCase().collect {
                _countries.value = it
            }
        }
    }
}