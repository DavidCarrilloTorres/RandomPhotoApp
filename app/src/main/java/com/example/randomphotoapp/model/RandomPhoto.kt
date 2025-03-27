package com.example.randomphotoapp.model

import com.google.gson.annotations.SerializedName

data class RandomPhoto(
    val id: String,
    @SerializedName("urls") val urls: Urls,
    val description: String?
)

data class Urls(
    val regular: String
)
