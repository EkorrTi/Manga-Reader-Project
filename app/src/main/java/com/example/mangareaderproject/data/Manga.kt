package com.example.mangareaderproject.data

import androidx.annotation.DrawableRes

data class Manga(
    val name: String,
    val description: String,
    @DrawableRes val coverImageResourceId: Int,
)
