package com.example.data.model

import com.google.gson.annotations.SerializedName

/**
 * I am thinking that each layer should have there data models.
 * If the models are not different from layer to layer we can use the same models.
 * Instead I created different data models for each layer to show case how we can make our mapping.
 */

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