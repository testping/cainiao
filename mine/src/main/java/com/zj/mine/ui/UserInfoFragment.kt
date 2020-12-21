package com.zj.mine.ui

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zj.common.base.BaseFragment
import com.zj.mine.R
import com.zj.mine.databinding.FragmentUserInfoBinding

class UserInfoFragment : BaseFragment<FragmentUserInfoBinding>() {

    private val args by navArgs<UserInfoFragmentArgs>()

    override fun getLayoutId() = R.layout.fragment_user_info

    override fun initView() {
        dataBinding?.apply {
            toolbarUserInfo.setNavigationOnClickListener { findNavController().navigateUp() }

            btnSaveUserInfo.setOnClickListener { findNavController().navigateUp() }
            info =  args.info
        }
    }
}