package com.example.android.githubusers.ui.list

import androidx.lifecycle.MutableLiveData
import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.domain.repository.UserRepository
import com.example.android.githubusers.ui.base.BaseViewModel
import com.example.android.githubusers.utils.Response
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    val userListLiveData = MutableLiveData<Response<List<User>>>(null)

    private var lastUserId = 0

    fun getUserList() {
        lastUserId = userListLiveData.value?.getDataIfSuccess()?.last()?.id ?: 0
        userRepository.getUserList(lastUserId)
            .execute(userListLiveData)
    }
}
