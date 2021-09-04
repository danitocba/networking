package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.example.networking.data.ApiClient
import com.example.networking.data.dtos.Post
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient.getPosts().enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(
                call: retrofit2.Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Post recuperados: ${response.body()?.size.toString()}", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

        })
    }
}