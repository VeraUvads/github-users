package com.example.android.githubusers.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.domain.repository.UserRepository
import com.example.android.githubusers.ui.base.BaseViewModel
import com.example.android.githubusers.utils.Response
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
