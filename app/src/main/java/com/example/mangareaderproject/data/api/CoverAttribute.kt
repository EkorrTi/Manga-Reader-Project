package com.example.mangareaderproject.data.api

import com.google.gson.annotations.SerializedName

data class CoverAttribute(
    @SerializedName("createdAt") val createdAt: String,
    val description: String,
    @SerializedName("fileName") val fileName: String,
    val locale: String,
    @SerializedName("updatedAt") val updatedAt: String,
    val version: Int,
    val volume: String
)