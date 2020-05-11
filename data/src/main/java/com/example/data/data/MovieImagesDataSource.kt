package com.example.data.data

import com.example.data.model.Photos
import io.reactivex.Single

interface MovieImagesDataSource {
    fun search(query: String, page: Int):Single<Photos>
}