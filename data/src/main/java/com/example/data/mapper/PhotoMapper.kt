package com.example.data.mapper

import com.example.data.model.Photo
import com.example.domain.mapper.Mapper
import javax.inject.Inject

class PhotoMapper @Inject constructor():Mapper<Photo,com.example.domain.model.Photo> {
    override fun map(input: Photo): com.example.domain.model.Photo =
        com.example.domain.model.Photo(
            id = input.id,
            title = input.title,
            farm = input.farm,
            isFamily = input.isfamily,
            isFriend = input.isfriend,
            isPublic = input.ispublic,
            owner = input.owner,
            secret = input.secret,
            server = input.server
        )

}