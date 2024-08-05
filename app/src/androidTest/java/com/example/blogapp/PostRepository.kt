package com.example.blogapp

class PostRepository(private val apiService: ApiService) {
    suspend fun getPosts() = apiService.getPosts()
    suspend fun createPost(title: String, content: String, author: String) = apiService.createPost(title, content, author)
}
