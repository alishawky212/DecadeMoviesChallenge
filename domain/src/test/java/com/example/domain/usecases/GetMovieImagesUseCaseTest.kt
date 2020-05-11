package com.example.domain.usecases

import com.example.domain.createPhotoTestData
import com.example.domain.createPhotoTestUrls
import com.example.domain.mapper.UrlListMapper
import com.example.domain.mapper.UrlMapper
import com.example.domain.repository.ImagesRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetMovieImagesUseCaseTest {

    private lateinit var useCase: GetMovieImagesUseCase
    private val mRepository: ImagesRepository = mock {}
    private val photoMapper: UrlListMapper = UrlListMapper(UrlMapper())

    @Before
    fun setUp() {
        useCase = GetMovieImagesUseCase(mRepository, photoMapper)
    }

    @Test
    fun getMovieImages() {
        Mockito.`when`(mRepository.getMovieImages("", 1))
            .thenReturn(Single.just(createPhotoTestData()))

        val test = useCase.getMovieImages("", 1).test()

        verify(mRepository).getMovieImages("", 1)

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(createPhotoTestUrls())
    }
}