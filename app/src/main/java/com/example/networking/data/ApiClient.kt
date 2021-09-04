package com.example.networking.data

import com.example.networking.data.dtos.Comment
import com.example.networking.data.dtos.Post
import com.example.networking.data.requests.UpdatePostTitleRequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiClient : ApiService{

    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    private val service = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    override fun getPosts(): Call<List<Post>> {
        return service.getPosts()
    }

    override fun getPost(id: Int): Call<Post> {
        return service.getPost(id)
    }

    override fun getPostComments(id: Int): Call<List<Comment>> {
        TODO("Not yet implemented")
    }

    override fun getComments(postId: Int?): Call<List<Comment>> {
        TODO("Not yet implemented")
    }

    override fun createPost(post: Post): Call<Post> {
        TODO("Not yet implemented")
    }

    override fun updatePost(id: Int, post: Post): Call<Post> {
        TODO("Not yet implemented")
    }

    override fun modifyPostTitle(id: Int, body: UpdatePostTitleRequest): Call<Post> {
        TODO("Not yet implemented")
    }

    override fun deletePost(id: Int): Call<Unit> {
        TODO("Not yet implemented")
    }


}