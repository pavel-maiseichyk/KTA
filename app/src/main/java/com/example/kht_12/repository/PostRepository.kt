package com.example.kht_12.repository

import androidx.lifecycle.LiveData
import com.example.kht_12.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
    fun see()
}