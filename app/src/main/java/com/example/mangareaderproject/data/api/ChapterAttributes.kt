package com.example.mangareaderproject.data.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class ChapterAttributes(
    val volume: String,
    val chapter: String,
    val title: String,
    @SerializedName("translatedLanguage") val translatedLanguage: String,
    @SerializedName("publishAt") val publishAt: Date,
    val pages: Int,
    val version: Int
)