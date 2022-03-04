package com.example.mangareaderproject.data

import androidx.annotation.DrawableRes
import java.io.Serializable


class Manga(
    val name: String,
    val description: String,
    @DrawableRes val coverImageResourceId: Int
    ) : Serializable {
}
