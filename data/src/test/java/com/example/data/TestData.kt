package com.example.data

import com.example.data.model.Photo
import com.example.data.model.Photos

val testPhoto = Photo(
    id = 1,
    title = "test",
    farm = 1,
    owner = "test",
    secret = "secret",
    server = 2,
    isfamily = 1,
    isfriend = 1,
    ispublic = 1
)

val expectedPhoto = com.example.domain.model.Photo(
    id = 1,
    title = "test",
    farm = 1,
    owner = "test",
    secret = "secret",
    server = 2,
    isFamily = 1,
    isFriend = 1,
    isPublic = 1
)

val apiResponsePhotos = Photo(
    id = 1,
    ispublic = 1,
    isfriend = 1,
    isfamily = 1,
    server = 2,
    secret = "secret",
    owner = "test",
    farm = 1,
    title = "test"
)

val apiResponsePhoto = Photos(
    page = 1,
    pages = 10,
    perpage = 10,
    photo = listOf(apiResponsePhotos),
    total = 100
)

fun createPhotoDataTestData():List<Photo>{
    return listOf(testPhoto)
}

fun createPhotoDomainTestData():List<com.example.domain.model.Photo>{
    return listOf(expectedPhoto)
}

fun createPhotosApiTestData():List<Photos>{
    return listOf(apiResponsePhoto)
}

fun createApiResponsePhotos():List<Photo>{
    return listOf(apiResponsePhotos)
}