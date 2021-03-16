package com.example.android.githubusers.ui.list

import androidx.lifecycle.MutableLiveData
import com.example.android.githubusers.data.Response
import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.domain.interactor.UserInteractor
import com.example.android.githubusers.ui.base.BaseViewModel
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : BaseViewModel() {

    val userListLiveData = MutableLiveData<Response<List<User>>>()

    private var lastUserId = 0

    fun getUserList() {
        lastUserId = userListLiveData.value?.getDataIfSuccess()?.last()?.id ?: 0
        userInteractor.getUserList(lastUserId)
            .execute(userListLiveData)
    }
}
