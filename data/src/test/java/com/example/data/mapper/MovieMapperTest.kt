package com.example.data.mapper

import com.example.data.model.Movie
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieMapperTest{
    private lateinit var mapper: MovieMapper
    private val testMovie = Movie(
        title = "test",
        rating = 5,
        cast = emptyList(),
        genres = emptyList(),
        year = 2008
    )

    private val expectedMovie = com.example.domain.model.Movie(
        title = "test",
        rating = 5,
        cast = emptyList(),
        genres = emptyList(),
        year = 2008
    )

    @Before
    fun setup(){
        mapper = MovieMapper()
    }

    @Test
    fun mapToDomainModel(){
        val mappedMovie = mapper.map(testMovie)
        assertTrue(mappedMovie == expectedMovie)
    }
}