package com.example.mangareaderproject.data.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMangaResponse(
    val data: Data,
    val response: String,
    val result: String
)