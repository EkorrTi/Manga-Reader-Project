package com.example.mangareaderproject.data

import androidx.annotation.DrawableRes
import java.io.Serializable


class MangaBare(
    val name: String,
    val description: String,
    @DrawableRes val coverImageResourceId: Int,
    val manga_id: String
    ) : Serializable
