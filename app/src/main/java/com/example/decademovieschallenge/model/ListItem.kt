package com.example.decademovieschallenge.model

interface ListItem {
    fun getType(): ItemType
}

enum class ItemType {
    YEAR_TYPE, MOVIE_TYPE
}