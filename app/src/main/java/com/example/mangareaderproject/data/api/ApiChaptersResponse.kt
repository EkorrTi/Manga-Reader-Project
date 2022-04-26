package com.example.mangareaderproject.data.api

data class ApiChaptersResponse(
    val result: String,
    val data: List<Chapter>,
    val limit: Int,
    val total: Int
)
