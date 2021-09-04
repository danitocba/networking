package com.example.networking.data

import com.example.networking.data.dtos.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiClient {

    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    private val service = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getPosts(): Result<List<Post>> {
        try {
            return withContext(Dispatchers.IO) {
                Result.Success(service.getPosts())
            }
        } catch (exception: Exception) {
            return Result.Error(exception)
        }
    }


    /*private suspend fun <T> executeFunction(function: suspend () -> T): Result<T> {
        return try {
            withContext(Dispatchers.IO) {
                Result.Success(function())
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }*/

}
