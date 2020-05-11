package com.example.data.data

import com.example.data.data.remote.FlickerApi
import com.example.data.model.Photos
import io.reactivex.Single
import javax.inject.Inject

class MovieImagesDataSourceImpl @Inject constructor(private val flickerApi: FlickerApi) :
    MovieImagesDataSource {
    override fun search(query: String, page: Int): Single<Photos> {
        return flickerApi.searchApi(searchQuery = query,page = page)
    }
}