package com.example.domain.usecases

import com.example.domain.createMovieListTestForRating
import com.example.domain.createMovieListTestForSize
import com.example.domain.repository.MoviesRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SearchMoviesUseCaseTest {
    private lateinit var useCase: SearchMoviesUseCase
    private val mRepository: MoviesRepository = mock {}

    @Before
    fun setUp() {
        useCase = SearchMoviesUseCase(mRepository)
    }

    @Test
    fun searchMoviesTestRatingSort() {
        val testData = createMovieListTestForRating()
        Mockito.`when`(mRepository.searchMovies(""))
            .thenReturn(Observable.fromIterable(testData))

        val test = useCase.searchMovies("").test()
        verify(mRepository).searchMovies("")

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue {
            it[2009]!![0].rating == 5
        }
        test.assertValue {
            it.size == 3
        }
    }

    @Test
    fun `searchMoviesReturn5ElementsForCategory`() {
        val testData = createMovieListTestForSize()
        Mockito.`when`(mRepository.searchMovies(""))
            .thenReturn(Observable.fromIterable(testData))

        val test = useCase.searchMovies("").test()
        verify(mRepository).searchMovies("")

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue {
            it.size == 1
        }

        test.assertValue {
            it[2009]!!.size == 5
        }

        test.assertValue {
            it[2009]!![0].rating == 5
        }

        test.assertValue{
            it[2009]!![4].rating == 2
        }
    }

}