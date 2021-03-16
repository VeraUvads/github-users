package com.example.android.githubusers.ui.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubusers.R
import com.example.android.githubusers.data.Response
import com.example.android.githubusers.di.ViewModelFactory
import com.example.android.githubusers.ui.base.BaseFragment
import com.example.android.githubusers.ui.detail.UserDetailInfoFragment
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment(R.layout.fragment_user_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val userListAdapter = UserListAdapter()

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(UserListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserList()
        userListAdapter.onItemClickListener = { // реализация навигации тут говно, не смотрите
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, UserDetailInfoFragment.newInstance(it.login))
                ?.commit()
        }
        recyclerView.adapter = userListAdapter

        recyclerView.addOnScrollListener(onScroll)

        viewModelSubscribe()
    }

    private val onScroll = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                viewModel.getUserList()
            }
        }
    }

    private fun viewModelSubscribe() {
        viewModel.userListLiveData.observe(
            this,
            { response ->
                when (response) {
                    is Response.Success -> {
                        userListAdapter.addContent(response.data.toMutableList())
                    }
                    is Response.Loading -> {
                    }
                    is Response.Error -> {
                    }
                }
            }
        )
    }
}
