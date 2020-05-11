package com.example.domain.repository

import com.example.domain.model.Movie
import io.reactivex.Observable
import io.reactivex.Single

interface MoviesRepository {
    fun getMovies():Single<List<Movie>>

    fun searchMovies(query: String): Observable<Movie>
}