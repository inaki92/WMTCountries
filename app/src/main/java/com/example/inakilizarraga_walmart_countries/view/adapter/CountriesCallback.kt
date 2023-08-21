package com.example.inakilizarraga_walmart_countries.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.inakilizarraga_walmart_countries.utils.ViewType

class CountriesCallback(private val oldList: List<ViewType>, private val newList: List<ViewType>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition] is ViewType.Letter && newList[newPosition] is ViewType.Letter
    }
}