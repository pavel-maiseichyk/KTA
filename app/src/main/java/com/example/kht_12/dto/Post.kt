package com.example.kht_12.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val amountOfLikes: Int = 0,
    val amountOfShared: Int = 0,
    val amountOfSeen: Int = 0
)