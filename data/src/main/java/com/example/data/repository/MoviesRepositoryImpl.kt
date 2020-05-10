package com.example.data.repository

import com.example.data.data.MoviesDataSource
import com.example.data.mapper.MovieListMapper
import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    private val moviesDataSource: MoviesDataSource,
    private val movieListMapper: MovieListMapper
) : MoviesRepository {
    override fun getMovies(): Single<List<Movie>> =
        moviesDataSource.getMovies()
            .map { movies ->
                movieListMapper.map(movies)
            }

    override fun searchMovies(query: String): Single<List<Movie>> {
        return moviesDataSource.searchMovies(query)
            .map {movie->
                movieListMapper.map(movie)
            }
    }
}