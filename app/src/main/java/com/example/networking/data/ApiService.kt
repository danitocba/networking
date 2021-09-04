package com.example.networking.data

import com.example.networking.data.dtos.Comment
import com.example.networking.data.dtos.Post
import com.example.networking.data.requests.UpdatePostTitleRequest
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("post/{id}")
    fun getPost(
        @Path("id") id: Int
    ): Call<Post>

    @GET("post/{id}/comments")
    fun getPostComments(
        @Path("id") id: Int
    ): Call<List<Comment>>

    @GET("comments")
    fun getComments(
        @Query("postId") postId: Int? = null
    ): Call<List<Comment>>

    @POST("posts")
    fun createPost(
        @Body post: Post
    ): Call<Post>

    @PUT("post/{id}")
    fun updatePost(
        @Path("id") id: Int,
        @Body post: Post
    ): Call<Post>

    @PATCH("post/{id}")
    fun modifyPostTitle(
        @Path("id") id: Int,
        @Body body: UpdatePostTitleRequest
    ): Call<Post>

    @DELETE("post/{id}")
    fun deletePost(
        @Path("id") id: Int
    ): Call<Unit>

}