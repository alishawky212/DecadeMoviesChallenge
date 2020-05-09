package com.example.data.data

import com.example.data.model.Photos
import io.reactivex.Single

interface SearchDataSource {
    fun search(query: String, page: Int):Single<Photos>
}