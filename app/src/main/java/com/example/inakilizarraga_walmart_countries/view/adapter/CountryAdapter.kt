package com.example.inakilizarraga_walmart_countries.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.inakilizarraga_walmart_countries.databinding.CountryItemmBinding
import com.example.inakilizarraga_walmart_countries.databinding.LetterItemBinding
import com.example.inakilizarraga_walmart_countries.model.Country
import com.example.inakilizarraga_walmart_countries.utils.ViewType

class CountryAdapter(
    private val countries: MutableList<ViewType> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        var temp = '0'
        val newTypes = mutableListOf<ViewType>()
        newCountries.sortedBy { it.name }.map { country ->
            country.name?.let {cName ->
                if (!cName.startsWith(temp)) {
                    temp = cName.first()
                    newTypes.add(ViewType.Letter(temp.toString()))

                }
                newTypes.add(ViewType.Country(country))
            }
        }

        val diffCallback = CountriesCallback(countries, newTypes)
        val diffTypes = DiffUtil.calculateDiff(diffCallback)
        countries.clear()
        countries.addAll(newTypes)

        diffTypes.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> LetterViewHolder(
                LetterItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> CountryViewHolder(
                CountryItemmBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = countries[position]) {
            is ViewType.Letter -> (holder as LetterViewHolder).bindLetter(item.letter)
            is ViewType.Country -> (holder as CountryViewHolder).bindCountry(item.country)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(countries[position]) {
            is ViewType.Letter -> 0
            else -> 1
        }
    }
}