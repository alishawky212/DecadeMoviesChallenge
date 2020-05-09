package com.example.domain.usecases

import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    fun getMovies():Single<List<Movie>>{
        return moviesRepository.getMovies().map {
            it.shuffled()
        }
    }
}