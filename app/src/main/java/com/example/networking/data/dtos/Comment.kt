package com.example.networking.data.dtos


data class Comment(
    val body: String? = "",
    val email: String? = "",
    val id: Int? = 0,
    val name: String? = "",
    val postId: Int? = 0
)