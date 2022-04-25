package com.example.mangareaderproject.network

import android.util.Log
import com.example.mangareaderproject.data.api.ApiChaptersResponse
import com.example.mangareaderproject.data.api.ApiMangaResponse
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.mangadex.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
//    .add(ChaptersJsonAdapter())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MangadexApiService {
    @GET("/manga/{manga_id}")
    suspend fun getManga(@Path("manga_id") id: String): ApiMangaResponse

    @GET("/manga/{manga_id}/aggregate")
    @WrappedChapters
    suspend fun getChapters(@Path("manga_id") id: String): ApiChaptersResponse
}

object MangadexApi{
    val retrofitService : MangadexApiService by lazy{
        retrofit.create(MangadexApiService::class.java)
    }
}
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class WrappedChapters

class ChaptersJsonAdapter{
    @WrappedChapters
    @FromJson
    fun fromJson(reader: JsonReader): ApiChaptersResponse {
        Log.i( "JsonAdapter", reader.nextString())
        Log.i( "JsonAdapter", reader.nextString())
        return ApiChaptersResponse("ok", HashMap())
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ApiChaptersResponse?) {
        throw UnsupportedOperationException()
    }
}