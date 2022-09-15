package com.example.testapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.databinding.DataBindingUtil
import com.example.testapplication.api.Api
import com.example.testapplication.api.entity.RandomUserResponse
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
                // TODO: Implement UI
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

    @Composable
    fun Greeting(string: String) {
        Text(string)
    }
}