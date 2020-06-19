package com.example.domain

import com.example.domain.model.Movie
import com.example.domain.model.Photo


fun createMovieListTestForRating():List<Movie>{
     val movie = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 5
    )
     val movie4 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 3
    )


     val movie2 = Movie(
        title = "",
        year = 2007,
        genres = listOf(),
        cast = listOf(),
        rating = 5
    )
     val movie3 = Movie(
        title = "",
        year = 2008,
        genres = listOf(),
        cast = listOf(),
        rating = 5
    )
    return listOf(movie,movie3,movie2,movie4)
}

fun createMovieListTestForSize():List<Movie>{
    val movie = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 1
    )
    val movie4 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 2
    )


    val movie2 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 3
    )
    val movie3 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 5
    )
    val movie1 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 4
    )
    val movie6 = Movie(
        title = "",
        year = 2009,
        genres = listOf(),
        cast = listOf(),
        rating = 5
    )

    return listOf(movie6,movie,movie2,movie1,movie3,movie4)
}

fun createPhotoTestData():List<Photo>{
    val photo1 = Photo(
        id = 1,
        title = "Photo1",
        server = 2,
        secret = "Photo1Secret",
        owner = "Photo1",
        isPublic = 1,
        isFriend = 1,
        isFamily = 1,
        farm = 1
    )

    val photo2 = Photo(
        id = 2,
        title = "Photo2",
        server = 3,
        secret = "Photo2Secret",
        owner = "Photo2",
        isPublic = 1,
        isFriend = 1,
        isFamily = 1,
        farm = 2
    )

    return listOf(photo1,photo2)
}

fun createPhotoTestUrls():List<String>{
    val url1 =  "https://farm1.static.flickr.com/2/1_Photo1Secret.jpg"
    val url2 =  "https://farm2.static.flickr.com/3/2_Photo2Secret.jpg"
    return listOf(url1,url2)
}