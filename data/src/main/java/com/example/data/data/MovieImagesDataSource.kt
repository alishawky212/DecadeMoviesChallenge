package com.example.data.data

import com.example.data.model.PhotosWrapper
import io.reactivex.Single

interface MovieImagesDataSource {
    fun getMovieImages(query: String, page: Int): Single<PhotosWrapper>
}