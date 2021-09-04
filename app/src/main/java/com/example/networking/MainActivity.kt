package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.example.networking.data.ApiClient
import com.example.networking.data.Result
import com.example.networking.data.dtos.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            val getPostResult = apiClient.getPosts()
            when (getPostResult) {
                is Result.Error -> handleErrorResult(getPostResult.exception.message.toString())
                is Result.Success -> handleSucessResult(getPostResult.data)
            }
        }
    }

    private fun handleSucessResult(lstPosts: List<Post>) {
        Toast.makeText(
            this@MainActivity,
            "Post recuperados: ${lstPosts.size}", Toast.LENGTH_SHORT
        ).show()
    }

    private fun handleErrorResult(errorMessage: String) {
        Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
    }
}