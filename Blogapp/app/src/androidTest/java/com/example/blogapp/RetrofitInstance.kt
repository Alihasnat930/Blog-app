package com.example.blogapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Field

interface ApiService {
    @GET("get_posts.php")
    suspend fun getPosts(): List<Post>

    @FormUrlEncoded
    @POST("create_post.php")
    suspend fun createPost(
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("author") author: String
    ): String
}

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.100.16/blog/") // Replace with your server IP or domain
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
