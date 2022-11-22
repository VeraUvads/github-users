package com.example.android.githubusers.feature.user_details.ui

import androidx.lifecycle.MutableLiveData
import com.example.android.githubusers.data_user.datasource.remote.model.UserDetailInfo
import com.example.android.githubusers.data_user.repository.UserRepository
import com.example.android.githubusers.utils.base.BaseViewModel
import com.example.android.githubusers.utils.network.Response
import javax.inject.Inject

class UserDetailInfoViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    val userLiveData = MutableLiveData<Response<UserDetailInfo>>()

    fun getUserDetails(login: String) {
        userRepository.getUserDetailInfo(login)
            .execute(userLiveData)
    }
}
