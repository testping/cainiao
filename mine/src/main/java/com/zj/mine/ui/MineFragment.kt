package com.zj.mine.ui

import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.launcher.ARouter
import com.zj.common.base.BaseFragment
import com.zj.mine.R
import com.zj.mine.databinding.FragmentMineBinding
import com.zj.service.repo.CniaoDbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class MineFragment : BaseFragment<FragmentMineBinding>() {

    private val viewModel: MineViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_mine

    override fun initView() {
        super.initView()
        dataBinding?.apply {
            vm = viewModel
            btnLogoutMine.setOnClickListener {
                CniaoDbHelper.deleteUserInfo(requireContext())
                ARouter.getInstance().build("/login/login").navigation()
            }

            ivUserIconMine.setOnClickListener {
                val info = viewModel.liveUser.value
                if (info == null) {
                    ARouter.getInstance().build("/login/login").navigation()
                } else {
                    val action =
                        MineFragmentDirections.actionMineFragmentToUserInfoFragment(info)
                    findNavController().navigate(action)
                }
            }

            tvUserNameMine.setOnClickListener {
                val info = viewModel.liveUser.value
                if (info == null) {
                    ARouter.getInstance().build("/login/login").navigation()
                } else {
                    val action =
                        MineFragmentDirections.actionMineFragmentToUserInfoFragment(info)
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun initConfig() {
        super.initConfig()
        CniaoDbHelper.getLiveUserInfo(requireContext()).observerKt {
            viewModel.getUserInfo(it?.token)
        }
    }
}