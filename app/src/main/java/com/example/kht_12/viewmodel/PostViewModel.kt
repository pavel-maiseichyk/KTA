package com.example.kht_12.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kht_12.repository.PostRepository
import com.example.kht_12.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val postRepository: PostRepository = PostRepositoryInMemoryImpl()
    val postData = postRepository.get()
    fun like() = postRepository.like()
    fun share() = postRepository.share()
    fun see() = postRepository.see()
}