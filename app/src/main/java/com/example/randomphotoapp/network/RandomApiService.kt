package com.example.randomphotoapp.network

import com.example.randomphotoapp.model.RandomPhoto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.unsplash.com/"
private const val ACCESS_KEY = "rRn994mxJLufa-HqwBRofOYLGxXC0NU2fhesy0o9qWw"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface RandomApiService {
    @GET("photos")
    suspend fun getRandomImages(
        @Query("client_id") clientId: String = ACCESS_KEY,
        @Query("query") query: String = "random",
        @Query("per_page") perPage: Int = 10
    ): List<RandomPhoto>
}

object RandomApi {
    val retrofitService: RandomApiService by lazy {
        retrofit.create(RandomApiService::class.java)
    }
}