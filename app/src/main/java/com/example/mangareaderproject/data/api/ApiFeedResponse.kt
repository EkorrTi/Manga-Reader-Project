package com.example.mangareaderproject.data.api

import com.google.gson.annotations.SerializedName

data class ApiFeedResponse(
    val result: String,
    val response: String,
    @SerializedName("data") val mangaList: List<Manga>,
    val limit: Int,
    val offset: Int,
    val total: Int,
)
