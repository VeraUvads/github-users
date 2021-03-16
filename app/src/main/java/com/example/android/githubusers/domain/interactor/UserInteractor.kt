package com.example.android.githubusers.domain.interactor

import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {
    fun getUserList(currentPage: Int): Single<List<User>> = userRepository.getUserList(currentPage)

    fun getUserDetailInfo(login: String): Single<UserDetailInfo> =
        userRepository.getUserDetailInfo(login)
}
