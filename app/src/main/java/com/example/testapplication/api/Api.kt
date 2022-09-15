package com.example.testapplication.api

import com.example.testapplication.api.entity.RandomUserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    // Retrofit Call
    @GET("api")
    fun randomUserRetrofit(): Call<RandomUserResponse>

    // RxJava Observable
    @GET("api")
    fun randomUserObservable(): Observable<RandomUserResponse>

    // Coroutine
    @GET("api")
    suspend fun randomUserCoroutine(): RandomUserResponse

}