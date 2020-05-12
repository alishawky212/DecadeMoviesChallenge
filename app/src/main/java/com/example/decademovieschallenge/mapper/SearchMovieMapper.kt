package com.example.decademovieschallenge.mapper

import com.example.decademovieschallenge.model.ListItem
import com.example.decademovieschallenge.model.YearItem
import com.example.domain.mapper.Mapper
import com.example.domain.model.Movie
import javax.inject.Inject

class SearchMovieMapper @Inject constructor(private val movieItemMapper: MovieItemMapper) :
    Mapper<HashMap<Int, List<Movie>>, List<ListItem>> {
    override fun map(input: HashMap<Int, List<Movie>>): List<ListItem> {
        val moviesListItem = ArrayList<ListItem>()
        input.keys.forEach { key ->
            moviesListItem.add(YearItem(key))
            input[key]?.forEach { movie ->
                moviesListItem.add(movieItemMapper.map(movie))
            }
        }
        return moviesListItem
    }

}
