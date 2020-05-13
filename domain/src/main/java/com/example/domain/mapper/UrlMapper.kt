package com.example.domain.mapper

import com.example.domain.model.Photo
import javax.inject.Inject

class UrlMapper @Inject constructor() : Mapper<Photo, String> {
    override fun map(input: Photo): String =
        "https://farm${input.farm}.static.flickr.com/${input.server}/${input.id}_${input.secret}.jpg"

}