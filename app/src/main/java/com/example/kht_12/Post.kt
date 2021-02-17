package com.example.kht_12

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean,
    var amountOfLikes: Int = 0,
    var amountOfShared: Int = 0,
    var amountOfSeen: Int = 0
)