package com.example.android.githubusers.domain.repository

import com.example.android.githubusers.data.RestApiService
import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.data.model.UserDetailInfo
import io.reactivex.Single
import javax.inject.Inject

interface UserRepository {
    fun getUserList(currentPage: Int): Single<List<User>>

    fun getUserDetailInfo(login: String): Single<UserDetailInfo>
}

class UserRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService,
) : UserRepository {
    override fun getUserList(currentPage: Int): Single<List<User>> = restApiService.getUserList(currentPage)

    override fun getUserDetailInfo(login: String): Single<UserDetailInfo> =
        restApiService.getUserDetailInfo(login)
}
