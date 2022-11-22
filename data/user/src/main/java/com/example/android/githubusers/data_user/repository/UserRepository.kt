package com.example.android.githubusers.data_user.repository

import com.example.android.githubusers.data_user.datasource.remote.RestApiService
import com.example.android.githubusers.data_user.datasource.remote.model.User
import com.example.android.githubusers.data_user.datasource.remote.model.UserDetailInfo
import io.reactivex.Single
import javax.inject.Inject

interface UserRepository {
    fun getUserList(currentPage: Int): Single<List<User>>

    fun getUserDetailInfo(login: String): Single<UserDetailInfo>
}

class UserRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService
) : UserRepository {
    override fun getUserList(currentPage: Int): Single<List<User>> =
        restApiService.getUserList(currentPage)

    override fun getUserDetailInfo(login: String): Single<UserDetailInfo> =
        restApiService.getUserDetailInfo(login)
}
