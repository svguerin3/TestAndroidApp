package com.example.testapplication.api.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    var gender: String,
    var name: UserName,
    var location: UserLocation,
    var email: String,
    var login: UserLogin,
    var dob: UserDob,
    var phone: String,
    var cell: String,
    var picture: UserPicture,
    var nat: String
)

@JsonClass(generateAdapter = true)
data class UserName(
    var title: String,
    var first: String,
    var last: String
)

@JsonClass(generateAdapter = true)
data class UserLocation(
    var street: Street,
    var city: String,
    var state: String,
    var country: String,
    var postcode: String,
    var coordinates: Coordinates
)

@JsonClass(generateAdapter = true)
data class Street(
    var number: String,
    var name: String
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    var latitude: String,
    var longitude: String
)

@JsonClass(generateAdapter = true)
data class UserLogin(
    var uuid: String,
    var username: String,
    var password: String
)

@JsonClass(generateAdapter = true)
data class UserDob(
    var date: String,
    var age: Int
)

@JsonClass(generateAdapter = true)
data class UserPicture(
    var large: String,
    var medium: String,
    var thumbnail: String
)