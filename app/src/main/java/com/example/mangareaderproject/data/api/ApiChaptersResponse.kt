package com.example.mangareaderproject.data.api

data class ApiChaptersResponse(
    val result: String,
    val volumes: HashMap<String, Volume>
)