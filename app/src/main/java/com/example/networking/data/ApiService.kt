package com.example.networking.data

import com.example.networking.data.dtos.Comment
import com.example.networking.data.dtos.Post
import com.example.networking.data.requests.UpdatePostTitleRequest
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("post/{id}")
    suspend fun getPost(
        @Path("id") id: Int
    ): Post

    @GET("post/{id}/comments")
    suspend fun getPostComments(
        @Path("id") id: Int
    ): List<Comment>

    @GET("comments")
    suspend fun getComments(
        @Query("postId") postId: Int? = null
    ): List<Comment>

    @POST("posts")
    suspend fun createPost(
        @Body post: Post
    ): Post

    @PUT("post/{id}")
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body post: Post
    ): Post

    @PATCH("post/{id}")
    suspend fun modifyPostTitle(
        @Path("id") id: Int,
        @Body body: UpdatePostTitleRequest
    ): Post

    @DELETE("post/{id}")
    suspend fun deletePost(
        @Path("id") id: Int
    )

}