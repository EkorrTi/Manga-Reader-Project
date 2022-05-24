package com.example.mangareaderproject.data.api

import com.google.gson.annotations.SerializedName


data class MangaAttributes(
//    val altTitles: List<AltTitle>,
//    val availableTranslatedLanguages: List<String>,
//    @SerializedName("chapterNumbersResetOnNewVolume") val chapterNumbersResetOnNewVolume: Boolean?,
//    @SerializedName("contentRating") val contentRating: String?,
    @SerializedName("createdAt") val createdAt: String?,
    val description: Description,
//    @SerializedName("isLocked") val isLocked: Boolean?,
//    @SerializedName("lastChapter") val lastChapter: String?,
//    @SerializedName("lastVolume") val lastVolume: String?,
//    val links: Links,
//    val originalLanguage: String?,
//    val publicationDemographic: String?,
//    val state: String?,
    val status: String?,
    val tags: List<Tag>,
    val title: Title,
    @SerializedName("updatedAt") val updatedAt: String?,
    val version: Int?,
    val year: Int?
)