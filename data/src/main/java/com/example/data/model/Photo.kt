package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: Long,
    @SerializedName("owner") val owner: String,
    @SerializedName("secret") val secret: String,
    @SerializedName("server") val server: Long,
    @SerializedName("farm") val farm: Long,
    @SerializedName("title") val title: String,
    @SerializedName("ispublic") val ispublic: Int,
    @SerializedName("isfriend") val isfriend: Int,
    @SerializedName("isfamily") val isfamily: Int
)