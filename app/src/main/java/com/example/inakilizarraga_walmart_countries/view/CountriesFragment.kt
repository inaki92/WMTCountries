package com.example.inakilizarraga_walmart_countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inakilizarraga_walmart_countries.R
import com.example.inakilizarraga_walmart_countries.databinding.FragmentCountriesBinding
import com.example.inakilizarraga_walmart_countries.utils.BaseFragment
import com.example.inakilizarraga_walmart_countries.utils.State
import com.example.inakilizarraga_walmart_countries.view.adapter.CountryAdapter
import com.example.inakilizarraga_walmart_countries.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CountriesFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCountriesBinding.inflate(layoutInflater)
    }

    private val cAdapter by lazy {
        CountryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.mRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cAdapter
        }

        lifecycleScope.launch {
            cViewModel.countries.collect { state ->
                when(state) {
                    State.LOADING -> {
                        binding.loadingBar.visibility = View.VISIBLE
                        binding.mRecycler.visibility = View.GONE

                    }
                    is State.SUCCESS -> {
                        binding.loadingBar.visibility = View.GONE
                        binding.mRecycler.visibility = View.VISIBLE
                        cAdapter.updateCountries(state.data)
                    }
                    is State.ERROR -> {
                        binding.loadingBar.visibility = View.GONE
                        binding.mRecycler.visibility = View.GONE
                        showError(state.error.message) {
                            cViewModel.fetchCountries()
                        }
                    }
                }
            }
        }

        return binding.root
    }
}