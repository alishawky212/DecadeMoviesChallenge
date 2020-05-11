package com.example.data.model

import com.google.gson.annotations.SerializedName

data class MovieWrapper(
    @SerializedName("movies")
    val movies: List<Movie>
)