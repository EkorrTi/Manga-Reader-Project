package com.example.mangareaderproject.data.api

import com.squareup.moshi.Json

data class Description(
    val en: String?,
    val pl: String?,
    @Json(name = "pt-br") val pt_br: String?
)