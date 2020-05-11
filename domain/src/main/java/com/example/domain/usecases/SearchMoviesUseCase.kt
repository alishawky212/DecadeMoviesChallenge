package com.example.domain.usecases

import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun searchMovies(searchQuery: String): Single<HashMap<Int, List<Movie>>> {
        return moviesRepository.searchMovies(searchQuery).groupBy {
            it.year
        }.flatMapSingle { it.sorted().take(5).toList() }.collect(
            { HashMap() },
            { map, movies -> map[movies[0].year] = movies }
        )
    }
}