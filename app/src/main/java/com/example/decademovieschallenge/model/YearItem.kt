package com.example.decademovieschallenge.model

import com.example.decademovieschallenge.model.ItemType.YEAR_TYPE

data class YearItem(
    val year: Int
) : ListItem {
    override fun getType(): ItemType = YEAR_TYPE
}