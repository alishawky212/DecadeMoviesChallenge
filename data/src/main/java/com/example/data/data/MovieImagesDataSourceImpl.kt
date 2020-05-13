package com.example.data.data

import com.example.data.data.remote.FlickerApi
import com.example.data.model.PhotosWrapper
import io.reactivex.Single
import javax.inject.Inject

class MovieImagesDataSourceImpl @Inject constructor(private val flickerApi: FlickerApi) :
    MovieImagesDataSource {
    override fun getMovieImages(query: String, page: Int): Single<PhotosWrapper> {
        return flickerApi.movieImagesApi(searchQuery = query,page = page)
    }
}