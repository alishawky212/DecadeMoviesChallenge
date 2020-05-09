package com.example.data.repository

import com.example.data.data.SearchDataSource
import com.example.data.mapper.PhotoListMapper
import com.example.domain.model.Photo
import com.example.domain.repository.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val searchDataSource: SearchDataSource,
    private val photoListMapper: PhotoListMapper
) : SearchRepository {
    override fun search(searchQuery: String, page: Int): Single<List<Photo>> {
        return searchDataSource.search(searchQuery, page)
            .map { photos ->
                photoListMapper.map(photos.photo)
            }
    }
}