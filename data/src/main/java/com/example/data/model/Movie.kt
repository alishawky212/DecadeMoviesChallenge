package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    var title: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("cast")
    val cast: List<String>,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("rating")
    val rating: Int
)