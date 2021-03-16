package com.example.android.githubusers.data

import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.data.model.UserDetailInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApiService {
    @GET("/users")
    fun getUserList(@Query("since") currentPage: Int): Single<List<User>>

    @GET("/users/{username}")
    fun getUserDetailInfo(@Path("username") login: String): Single<UserDetailInfo>
}
