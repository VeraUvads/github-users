package com.example.android.githubusers.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.android.githubusers.R
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.extensions.appComponent
import com.example.android.githubusers.ui.base.BaseFragment
import com.example.android.githubusers.utils.Response
import kotlinx.android.synthetic.main.fragment_user_detail_info.*
import javax.inject.Inject

class UserDetailInfoFragment : BaseFragment(R.layout.fragment_user_detail_info) {

    @Inject
    lateinit var viewModel: UserDetailInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.appComponent?.inject(this)
        arguments?.let {
            val nickName = it.getString(NICKNAME)
            viewModel.getUserDetails(nickName!!)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        setClickListeners()
    }

    private fun setClickListeners() {
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun observe() {
        viewModel.userLiveData.observe(
            viewLifecycleOwner
        ) { response ->
            when (response) {
                is Response.Success -> {
                    showResult(response.data)
                }
                is Response.Error -> {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }

    private fun showResult(data: UserDetailInfo) {
        Glide.with(requireContext()).load(data.avatar_url).into(avatar)
        nickname.text = data.login
        location.text = data.location
        link.text = data.html_url
    }

    companion object {
        private const val NICKNAME = "NICKNAME"
        fun newInstance(nickName: String) = UserDetailInfoFragment().apply {
            val bundle = Bundle().apply {
                putString(NICKNAME, nickName)
            }
            arguments = bundle
        }
    }
}
