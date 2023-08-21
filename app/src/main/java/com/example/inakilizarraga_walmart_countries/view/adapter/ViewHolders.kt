package com.example.inakilizarraga_walmart_countries.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.inakilizarraga_walmart_countries.databinding.CountryItemmBinding
import com.example.inakilizarraga_walmart_countries.databinding.LetterItemBinding
import com.example.inakilizarraga_walmart_countries.model.Country

class LetterViewHolder(
    private val binding: LetterItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindLetter(letter: String) {
        binding.letterName.text = letter
    }

}

class CountryViewHolder(
    private val binding: CountryItemmBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindCountry(item: Country) {
        binding.countryNameRegion.text = String.format("${item.name}, ${item.region}")
        binding.countryCode.text = item.code
        binding.countryCapital.text = item.capital
    }

}