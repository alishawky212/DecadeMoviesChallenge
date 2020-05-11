package com.example.data.repository

import com.example.data.data.SearchDataSource
import com.example.data.mapper.PhotoListMapper
import com.example.domain.model.Photo
import com.example.domain.repository.ImagesRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource,
    private val photoListMapper: PhotoListMapper
) : ImagesRepository {
    override fun getMovieImages(searchQuery: String, page: Int): Single<List<Photo>> {
        return searchDataSource.search(searchQuery, page)
            .map { photos ->
                photoListMapper.map(photos.photo)
            }
    }
}