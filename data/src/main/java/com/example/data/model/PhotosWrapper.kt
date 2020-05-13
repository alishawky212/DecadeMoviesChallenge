package com.example.data.model

import com.google.gson.annotations.SerializedName

data class PhotosWrapper(
    @SerializedName("photos")
    val photos: Photos
)