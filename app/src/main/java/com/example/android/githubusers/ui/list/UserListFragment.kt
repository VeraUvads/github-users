package com.example.android.githubusers.ui.list

import android.os.Bundle
import android.view.View
import com.example.android.githubusers.R
import com.example.android.githubusers.data_user.datasource.remote.model.User
import com.example.android.githubusers.utils.extensions.appComponent
import com.example.android.githubusers.utils.network.base.BaseFragment
import com.example.android.githubusers.feature.user_details.detail.UserDetailInfoFragment
import com.example.android.githubusers.utils.Response
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : com.example.android.githubusers.utils.network.base.BaseFragment(R.layout.fragment_user_list) {

    private val userListAdapter = UserListAdapter(::navigateToDetail)

    @Inject
    lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.appComponent?.inject(this)
        viewModelSubscribe()
        viewModel.getUserList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = userListAdapter
    }

    private fun navigateToDetail(user: com.example.android.githubusers.data_user.datasource.remote.model.User) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, com.example.android.githubusers.feature.user_details.detail.UserDetailInfoFragment.newInstance(user.login))
            .addToBackStack("UserListFragment")
            .commit()
    }

    private fun viewModelSubscribe() {
        viewModel.userListLiveData.observe(
            this
        ) { response ->
            when (response) {
                is com.example.android.githubusers.utils.Response.Success -> {
                    userListAdapter.addContent(response.data.toMutableList())
                }
                else -> {}
            }
        }
    }
}
