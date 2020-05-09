package com.example.domain.repository

import com.example.domain.model.Photo
import io.reactivex.Single

interface SearchRepository {
    fun search(searchQuery:String,page:Int):Single<List<Photo>>
}