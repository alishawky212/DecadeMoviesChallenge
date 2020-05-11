package com.example.domain.mapper

import com.example.domain.model.Photo
import javax.inject.Inject

class UrlListMapper @Inject constructor(private val urlMapper:UrlMapper):Mapper<List<Photo>,List<String>> {
    override fun map(input: List<Photo>): List<String> =
        input.map {
            urlMapper.map(it)
        }

}