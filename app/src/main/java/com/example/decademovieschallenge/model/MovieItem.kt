package com.example.decademovieschallenge.model

import android.os.Parcelable
import com.example.decademovieschallenge.model.ItemType.MOVIE_TYPE
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItem(
    val title: String,
    val year: Int,
    val genres: List<String>,
    val cast: List<String>,
    val rate: Int
) : ListItem, Parcelable {
    override fun getType(): ItemType = MOVIE_TYPE
}