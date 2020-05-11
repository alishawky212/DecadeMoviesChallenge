package com.example.decademovieschallenge.mapper

import com.example.decademovieschallenge.model.ListItem
import com.example.domain.mapper.Mapper
import com.example.domain.model.Movie
import javax.inject.Inject

class MovieItemListMapper @Inject constructor(private val movieItemMapper: MovieItemMapper) :
    Mapper<List<Movie>, List<ListItem>> {
    override fun map(input: List<Movie>): List<ListItem> {
        return input.map { movie ->
            movieItemMapper.map(movie)
        }
    }
}