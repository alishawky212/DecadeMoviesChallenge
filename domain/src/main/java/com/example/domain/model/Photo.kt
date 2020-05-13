package com.example.domain.model

data class Photo(
    val id: Long,
    val owner: String,
    val secret: String,
    val server: Long,
    val farm: Long,
    val title: String,
    val isPublic: Int,
    val isFriend: Int,
    val isFamily: Int
)