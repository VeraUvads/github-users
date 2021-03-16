package com.example.android.githubusers.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.android.githubusers.data.Response
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.domain.interactor.UserInteractor
import com.example.android.githubusers.ui.base.BaseViewModel
import javax.inject.Inject

class UserDetailInfoViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : BaseViewModel() {

    val userLiveData = MutableLiveData<Response<UserDetailInfo>>()

    fun getUserDetails(login: String) {
        userInteractor.getUserDetailInfo(login)
            .execute(userLiveData)
    }
}
