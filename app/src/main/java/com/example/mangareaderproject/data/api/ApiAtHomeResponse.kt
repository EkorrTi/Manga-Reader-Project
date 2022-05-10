package com.example.mangareaderproject.data.api

import com.google.gson.annotations.SerializedName

data class ApiAtHomeResponse(
    val result: String,
    @SerializedName("baseUrl") val baseUrl: String,
    @SerializedName("chapter") val chapterFiles: ChapterFiles
)
