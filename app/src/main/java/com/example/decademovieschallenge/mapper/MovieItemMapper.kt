package com.example.decademovieschallenge.mapper

import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.MovieItem
import com.example.domain.mapper.Mapper
import com.example.domain.model.Movie
import javax.inject.Inject

class MovieItemMapper @Inject constructor():Mapper<Movie,ListItem> {
    override fun map(input: Movie): ListItem =
        MovieItem(
            title = input.title,
            cast = input.cast,
            genres = input.genres,
            year = input.year,
            rate = input.rating
        )
}