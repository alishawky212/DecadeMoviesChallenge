package com.example.domain.usecases

import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun searchMovies(searchQuery: String): Single<Map<Int, List<Movie>>> {
        return moviesRepository.searchMovies(searchQuery)
            .flatMap {
                val sortedList = it.sortedByDescending { movie ->
                    movie.rating
                }
                val map = sortedList.groupBy { movie ->
                    movie.year
                }
                Single.just(map)
            }
    }
}