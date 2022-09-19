package com.example.testapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.testapplication.api.Api
import com.example.testapplication.api.entity.RandomUserInfo
import com.example.testapplication.api.entity.RandomUserResponse
import com.example.testapplication.api.entity.User
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private val networkService = NetworkService()
    private val retrofit = networkService.getRetrofitInstance()

    lateinit var api: Api
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        api = retrofit.create(Api::class.java)

        getRandomUser()
    }

    private fun getRandomUser() {
        val response = api.randomUserRetrofit()
        response.enqueue(object : Callback<RandomUserResponse> {
            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                response.body()?.let {
                    setupUserUi(it.results.first())
                }
            }

            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.data_fetch_error),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    private fun setupUserUi(user: User) {
        Glide.with(this)
            .load(user.picture.large)
            .centerCrop()
            .into(binding.userImage)

        binding.username.text = user.login.username
        binding.name.text = "${user.name.first} ${user.name.last}"
    }

    @Composable
    fun Greeting(string: String) {
        Text(string)
    }
}