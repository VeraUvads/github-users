package com.example.android.githubusers.ui.list

import android.os.Bundle
import android.view.View
import com.example.android.githubusers.R
import com.example.android.githubusers.data.model.User
import com.example.android.githubusers.extensions.appComponent
import com.example.android.githubusers.ui.base.BaseFragment
import com.example.android.githubusers.ui.detail.UserDetailInfoFragment
import com.example.android.githubusers.utils.Response
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment(R.layout.fragment_user_list) {

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

    private fun navigateToDetail(user: User) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, UserDetailInfoFragment.newInstance(user.login))
            .addToBackStack("UserListFragment")
            .commit()
    }

    private fun viewModelSubscribe() {
        viewModel.userListLiveData.observe(
            this
        ) { response ->
            when (response) {
                is Response.Success -> {
                    userListAdapter.addContent(response.data.toMutableList())
                }
                else -> {}
            }
        }
    }
}
