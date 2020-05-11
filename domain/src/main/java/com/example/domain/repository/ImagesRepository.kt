package com.example.domain.repository

import com.example.domain.model.Photo
import io.reactivex.Single

interface ImagesRepository {
    fun getMovieImages(searchQuery:String,page:Int):Single<List<Photo>>
}