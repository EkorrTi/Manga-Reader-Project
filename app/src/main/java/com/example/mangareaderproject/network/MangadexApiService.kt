package com.example.mangareaderproject.network

import com.example.mangareaderproject.data.api.ApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.mangadex.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MangadexApiService {
    @GET("/manga/{manga_id}")
    suspend fun getManga(@Path("manga_id") id: String): ApiResponse
}

object MangadexApi{
    val retrofitService : MangadexApiService by lazy{
        retrofit.create(MangadexApiService::class.java)
    }
}