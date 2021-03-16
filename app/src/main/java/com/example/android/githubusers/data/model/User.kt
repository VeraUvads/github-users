package com.example.android.githubusers.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: Int,
    val avatar_url: String,
    val login: String
)
