package com.example.data.repository

import com.example.data.*
import com.example.data.data.MovieImagesDataSource
import com.example.data.data.MoviesDataSource
import com.example.data.mapper.PhotoListMapper
import com.example.data.mapper.PhotoMapper
import com.example.data.model.PhotosWrapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ImagesRepositoryImplTest {

    private lateinit var repositoryImpl: ImagesRepositoryImpl
    private val moviesImagesDataSource: MovieImagesDataSource = mock {}
    private val photoListMapper = PhotoListMapper(PhotoMapper())



    @Before
    fun setUp() {
        repositoryImpl = ImagesRepositoryImpl(
            moviesImagesDataSource,
            photoListMapper
        )
    }

    @Test
    fun getMovieImages() {
        Mockito.`when`(moviesImagesDataSource.getMovieImages("",1))
            .thenReturn(Single.just(PhotosWrapper(apiResponsePhoto)))

        val test = repositoryImpl.getMovieImages("",1).test()

        verify(moviesImagesDataSource).getMovieImages("", 1)

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(createPhotoDomainTestData())
    }
}