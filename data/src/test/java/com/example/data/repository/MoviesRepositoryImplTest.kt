package com.example.data.repository

import com.example.data.data.MoviesDataSource
import com.example.data.mapper.MovieListMapper
import com.example.data.mapper.MovieMapper
import com.example.data.model.Movie
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

class MoviesRepositoryImplTest {

    private lateinit var moviesRepositoryImpl: MoviesRepositoryImpl
    private val moviesDataSource: MoviesDataSource = mock {}
    private val movieMapper: MovieMapper = MovieMapper()
    private val movieListMapper: MovieListMapper = MovieListMapper(movieMapper)

    private val testMovie = Movie(
        title = "test",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )
    private val testMovie1 = Movie(
        title = "testMov",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )
    private val testMovie2 = Movie(
        title = "testMo",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )
    private val testMovie3 = Movie(
        title = "testMovie",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )
    private val testMovie4 = Movie(
        title = "testM",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )

    private val exceptedMovie = com.example.domain.model.Movie(
        title = "test",
        rating = 5,
        year = 2009,
        genres = emptyList(),
        cast = emptyList()
    )

    private val exceptedDomainMovie1 = com.example.domain.model.Movie(
        title = "testMov",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )

    private val exceptedDomainMovie2 = com.example.domain.model.Movie(
        title = "testMovie",
        year = 2009,
        genres = emptyList(),
        cast = emptyList(),
        rating = 5
    )

    @Before
    fun setUp(){
        moviesRepositoryImpl = MoviesRepositoryImpl(
            moviesDataSource,
            movieListMapper,
            movieMapper
        )
    }

    @Test
    fun getMovies() {
        Mockito.`when`(moviesDataSource.getMovies())
            .thenReturn(Single.just(listOf(testMovie)))

        val test = moviesRepositoryImpl.getMovies().test()

        verify(moviesDataSource).getMovies()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(listOf(exceptedMovie))


    }

    @Test
    fun searchMoviesReturnValues() {
        Mockito.`when`(moviesDataSource.searchMovies())
            .thenReturn(Observable.fromIterable(listOf(testMovie,testMovie1,testMovie2,testMovie3,testMovie4)))

        val test = moviesRepositoryImpl.searchMovies("Mov").test()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(2)
        test.assertValueAt(0,exceptedDomainMovie1)
        test.assertValueAt(1,exceptedDomainMovie2)

    }

    @Test
    fun searchMoviesReturnEmpty() {
        Mockito.`when`(moviesDataSource.searchMovies())
            .thenReturn(Observable.fromIterable(listOf(testMovie,testMovie1,testMovie2,testMovie3,testMovie4)))

        val test = moviesRepositoryImpl.searchMovies("").test()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(0)

    }
}