package com.example.data.data

import com.example.data.model.Movie
import io.reactivex.Single

interface MoviesDataSource {
    fun getMovies():Single<List<Movie>>

    fun searchMovies(query:String):Single<List<Movie>>
}