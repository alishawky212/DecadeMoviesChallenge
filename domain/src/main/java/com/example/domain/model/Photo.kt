package com.example.domain.model

data class Photo(
    val id: Int,
    val owner: String,
    val secret: String,
    val server: Int,
    val farm: Int,
    val title: String,
    val isPublic: Int,
    val isFriend: Int,
    val isFamily: Int
)