package com.example.domain.usecases

import com.example.domain.createMovieListTestForSize
import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetMoviesUseCaseTest {

    private lateinit var useCase: GetMoviesUseCase
    private val mRepository: MoviesRepository = mock {}

    private lateinit var testData: List<Movie>

    @Before
    fun setUp() {
        useCase = GetMoviesUseCase(mRepository)
        testData = createMovieListTestForSize()
    }

    @Test
    fun getMovies() {
        Mockito.`when`(mRepository.getMovies())
            .thenReturn(Single.just(testData))

        val test = useCase.getMovies().test()
        verify(mRepository).getMovies()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(testData)
    }
}