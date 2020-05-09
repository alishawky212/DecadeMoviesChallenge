package com.example.domain.usecases

import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun searchMovies(searchQuery: String): Single<List<Movie>> {
        return moviesRepository.searchMovies(searchQuery)
            .map { movies ->
                movies.sortedByDescending { it.rating }
            }
    }
}