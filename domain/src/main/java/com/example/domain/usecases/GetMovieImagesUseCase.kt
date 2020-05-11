package com.example.domain.usecases

import com.example.domain.mapper.UrlListMapper
import com.example.domain.repository.ImagesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(
    private val imagesRepository: ImagesRepository,
    private val urlListMapper: UrlListMapper
) {
    fun getMovieImages(movieTitle: String, page: Int): Single<List<String>> {
        return imagesRepository.getMovieImages(movieTitle, page)
            .flatMap {
                val photosUrl = urlListMapper.map(it)
                Single.just(photosUrl)
            }
    }
}