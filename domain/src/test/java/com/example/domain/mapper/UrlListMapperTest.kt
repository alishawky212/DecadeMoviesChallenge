package com.example.domain.mapper

import com.example.domain.createPhotoTestData
import com.example.domain.createPhotoTestUrls
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UrlListMapperTest {
    private lateinit var urlListMapper: UrlListMapper

    @Before
    fun setUp() {
        urlListMapper = UrlListMapper(UrlMapper())
    }

    @Test
    fun map() {
        val expectedUrls = createPhotoTestUrls()
        val testPhotos = createPhotoTestData()

        val urls = urlListMapper.map(testPhotos)

        assertArrayEquals(expectedUrls.toTypedArray(),urls.toTypedArray())
    }
}