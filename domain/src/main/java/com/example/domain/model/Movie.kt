package com.example.domain.model

data class Movie(
    var title: String,
    val year: Int,
    val cast: List<String>,
    val genres: List<String>,
    val rating: Int
)