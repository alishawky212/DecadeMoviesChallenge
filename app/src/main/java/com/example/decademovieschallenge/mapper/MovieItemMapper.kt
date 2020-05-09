package com.example.decademovieschallenge.mapper

import com.example.decademovieschallenge.model.MovieItem
import com.example.domain.mapper.Mapper
import com.example.domain.model.Movie
import javax.inject.Inject

class MovieItemMapper @Inject constructor():Mapper<Movie,MovieItem> {
    override fun map(input: Movie): MovieItem =
        MovieItem(
            title = input.title,
            cast = input.cast,
            genres = input.genres,
            year = input.year,
            rate = input.rating
        )
}