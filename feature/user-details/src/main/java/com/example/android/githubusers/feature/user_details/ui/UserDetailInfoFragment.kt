package com.example.android.githubusers.feature.user_details.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android.githubusers.R
import com.example.android.githubusers.data.model.UserDetailInfo
import com.example.android.githubusers.data_user.datasource.remote.model.UserDetailInfo
import com.example.android.githubusers.extensions.appComponent
import com.example.android.githubusers.feature.user_details.R
import com.example.android.githubusers.feature.user_details.databinding.FragmentUserDetailInfoBinding
import com.example.android.githubusers.feature.user_details.di.UserDetailContentHolder
import com.example.android.githubusers.ui.base.BaseFragment
import com.example.android.githubusers.utils.Response
import com.example.android.githubusers.utils.base.BaseFragment
import com.example.android.githubusers.utils.network.Response
import kotlinx.android.synthetic.main.fragment_user_detail_info.*
import javax.inject.Inject

class UserDetailInfoFragment : BaseFragment(R.layout.fragment_user_detail_info) {

    @Inject
    lateinit var viewModel: UserDetailInfoViewModel

    private val viewBinding by viewBinding<FragmentUserDetailInfoBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserDetailContentHolder.userDetailComponent?.inject(this)
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
        viewBinding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        viewBinding.toolbar.setNavigationOnClickListener {
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
        Glide.with(requireContext()).load(data.avatar_url).into(viewBinding.avatar)
        viewBinding.nickname.text = data.login
        viewBinding.location.text = data.location
        viewBinding.link.text = data.html_url
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
