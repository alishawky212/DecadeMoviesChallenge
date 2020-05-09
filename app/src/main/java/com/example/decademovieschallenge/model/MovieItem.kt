package com.example.decademovieschallenge.model

import com.example.decademovieschallenge.model.ItemType.MOVIE_TYPE

data class MovieItem(
    val title: String,
    val year: Int,
    val genres: List<String>,
    val cast: List<String>,
    val rate: Int
) : ListItem {
    override fun getType(): ItemType = MOVIE_TYPE
}