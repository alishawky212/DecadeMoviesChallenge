package com.example.domain.mapper

import com.example.domain.model.Photo
import junit.framework.Assert.assertTrue
import org.junit.Test

class UrlMapperTest {

    private val mapper = UrlMapper()

    @Test
    fun map() {
        val testPhoto =  Photo(
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
        val expectedUrl =  "https://farm2.static.flickr.com/3/2_Photo2Secret.jpg"
        val url = mapper.map(testPhoto)

        assertTrue(url == expectedUrl)
    }
}