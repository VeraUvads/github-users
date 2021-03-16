package com.example.android.githubusers.data.repository

import com.example.android.githubusers.data.RestApiService
import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService,
) : UserRepository {
    override fun getUserList(currentPage: Int): Single<List<User>> = restApiService.getUserList(currentPage)

    override fun getUserDetailInfo(login: String): Single<UserDetailInfo> =
        restApiService.getUserDetailInfo(login)
}
