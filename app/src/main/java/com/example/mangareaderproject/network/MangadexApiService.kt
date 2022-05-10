package com.example.mangareaderproject.network

import com.example.mangareaderproject.data.api.ApiAtHomeResponse
import com.example.mangareaderproject.data.api.ApiChaptersResponse
import com.example.mangareaderproject.data.api.ApiMangaResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.mangadex.org"
//var BASE_URL_CHAPTERS = ""//"https://uploads.mangadex.org"

val gson = GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    .serializeNulls()
    .create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .build()

interface MangadexApiService {
    @GET("/manga/{manga_id}")
    suspend fun getManga(@Path("manga_id") id: String): ApiMangaResponse

    @GET("/manga/{manga_id}/feed?translatedLanguage[]=en&limit=500&order%5Bvolume%5D=asc&order%5Bchapter%5D=asc&includes[]=scanlation_group")
    suspend fun getChapters(@Path("manga_id") id: String): ApiChaptersResponse

    @GET("/at-home/server/{chapter_id}")
    suspend fun getChapterAndServer(@Path("chapter_id") chapterID: String): ApiAtHomeResponse
}

object MangadexApi{
    val retrofitService : MangadexApiService by lazy{
        retrofit.create(MangadexApiService::class.java)
    }

//    lateinit var retrofitServiceChapters : MangadexApiService
//    val retrofitServiceChapters: MangadexApiService by lazy {
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .baseUrl(BASE_URL_CHAPTERS)
//            .build()
//            .create(MangadexApiService::class.java)
//    }

//    fun createChapterService(base_url: String){
//        retrofitServiceChapters = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .baseUrl(BASE_URL_CHAPTERS)
//            .build()
//            .create(MangadexApiService::class.java)
//    }
}