package com.example.android.githubusers.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.android.githubusers.R
import com.example.android.githubusers.data.Response
import com.example.android.githubusers.di.ViewModelFactory
import com.example.android.githubusers.ui.base.BaseFragment
import com.example.android.githubusers.ui.list.UserListFragment
import kotlinx.android.synthetic.main.fragment_user_detail_info.*
import javax.inject.Inject

class UserDetailInfoFragment : BaseFragment(R.layout.fragment_user_detail_info) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var nickName: String

    companion object {
        fun newInstance(nickName: String) = UserDetailInfoFragment().apply {
            this.nickName = nickName
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(UserDetailInfoViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelSubscribe()

        viewModel.getUserDetails(nickName)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, UserListFragment())
                ?.addToBackStack("tag")?.commit()
        }
    }

    private fun viewModelSubscribe() {
        viewModel.userLiveData.observe(
            this,
            { response ->
                when (response) {
                    is Response.Success -> {
                        response.data.let {
                            Glide.with(requireContext()).load(it.avatar_url).into(avatar)
                            nickname.text = it.login
                            location.text = it.location
                            link.text = it.html_url
                        }
                    }
                    is Response.Error -> {
                        Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }
}
