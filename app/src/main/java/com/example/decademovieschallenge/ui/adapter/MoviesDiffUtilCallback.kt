package com.example.decademovieschallenge.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.MovieItem
import com.example.decademovieschallenge.model.YearItem

class MoviesDiffUtilCallback constructor(private val oldList: List<ListItem>,
                                         private val newList: List<ListItem>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]

        return if (oldListItem::class == newListItem::class) {
            if (oldListItem is YearItem)
                oldListItem.year == (newListItem as YearItem).year
            else
                (oldListItem as MovieItem).title == (newListItem as MovieItem).title
        } else
            false
    }

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]

        return if (oldListItem::class == newListItem::class) {
            oldListItem == newListItem
        } else
            false
    }

}