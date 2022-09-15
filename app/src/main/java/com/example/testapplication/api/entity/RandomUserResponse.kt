package com.example.testapplication.api.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomUserResponse(
    var results: List<User>,
    var info: RandomUserInfo
)

@JsonClass(generateAdapter = true)
data class RandomUserInfo(
    var seed: String,
    var results: Int,
    var page: Int,
    var version: String
)