package com.example.android.githubusers.data_user.datasource.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDetailInfo(
    val login: String,
    val avatar_url: String,
    val html_url: String,
    val location: String
)
