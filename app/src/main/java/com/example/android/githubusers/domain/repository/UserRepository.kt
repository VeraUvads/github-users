package com.example.android.githubusers.domain.repository

import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.data.model.UserDetailInfo
import io.reactivex.Single

interface UserRepository {
    fun getUserList(currentPage: Int): Single<List<User>>

    fun getUserDetailInfo(login: String): Single<UserDetailInfo>
}
