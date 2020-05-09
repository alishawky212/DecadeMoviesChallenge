package com.example.data.mapper

import com.example.data.model.Movie
import com.example.domain.mapper.Mapper
import javax.inject.Inject

class MovieListMapper @Inject constructor(private val movieMapper: MovieMapper):Mapper<List<Movie>,List<com.example.domain.model.Movie>> {
    override fun map(input: List<Movie>): List<com.example.domain.model.Movie> =
        input.map {
            movieMapper.map(it)
        }

}