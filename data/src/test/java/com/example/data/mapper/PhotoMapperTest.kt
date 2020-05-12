package com.example.data.mapper

import com.example.data.expectedPhoto
import com.example.data.testPhoto
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PhotoMapperTest {

    private lateinit var mapper: PhotoMapper


    @Before
    fun setUp() {
        mapper = PhotoMapper()
    }

    @Test
    fun map() {
        val mappedPhoto = mapper.map(testPhoto)
        assertTrue(mappedPhoto == expectedPhoto)
    }
}