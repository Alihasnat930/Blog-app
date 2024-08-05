package com.example.blogapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    val posts = liveData(Dispatchers.IO) {
        val retrievedPosts = repository.getPosts()
        emit(retrievedPosts)
    }

    fun createPost(title: String, content: String, author: String) = liveData(Dispatchers.IO) {
        val response = repository.createPost(title, content, author)
        emit(response)
    }
}
