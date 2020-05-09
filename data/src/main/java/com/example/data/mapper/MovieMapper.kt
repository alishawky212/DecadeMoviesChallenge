package com.example.data.mapper

import com.example.data.model.Movie
import com.example.domain.mapper.Mapper
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<Movie,com.example.domain.model.Movie> {
    override fun map(input: Movie): com.example.domain.model.Movie =
        com.example.domain.model.Movie(
            title = input.title,
            year = input.year,
            rating = input.rating,
            genres = input.genres,
            cast = input.cast
        )

}