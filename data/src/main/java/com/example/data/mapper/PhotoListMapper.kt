package com.example.data.mapper

import com.example.data.model.Photo
import com.example.domain.mapper.Mapper
import javax.inject.Inject

class PhotoListMapper @Inject constructor(private val photoMapper: PhotoMapper):Mapper<List<Photo>,List<com.example.domain.model.Photo>> {
    override fun map(input: List<Photo>): List<com.example.domain.model.Photo> {
        return input.map {photo ->
            photoMapper.map(photo)
        }
    }

}