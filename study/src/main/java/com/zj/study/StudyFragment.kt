package com.zj.study

import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.blankj.utilcode.util.LogUtils
import com.zj.common.base.BaseFragment
import com.zj.service.repo.CniaoDbHelper
import com.zj.study.databinding.FragmentStudyBinding
import com.zj.study.ui.StudyLoadStateAdapter
import com.zj.study.ui.StudyViewMode
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudyFragment : BaseFragment<FragmentStudyBinding>() {

    private val viewModel: StudyViewMode by viewModel()

    override fun getLayoutId() = R.layout.fragment_study

    override fun initView() {
        dataBinding?.vm = viewModel
    }

    override fun initData() {
        CniaoDbHelper.getLiveUserInfo(requireContext()).observerKt {
            viewModel.obUserInfo.set(it)
        }

        viewModel.getStudyData()

        viewModel.apply {
            adapter.withLoadStateFooter(footer = StudyLoadStateAdapter())
            adapter.addLoadStateListener { state ->
                when (state.refresh) {
                    is LoadState.NotLoading -> {
                    }
                    is LoadState.Loading -> {
                    }
                    is LoadState.Error -> {
                    }
                }
                LogUtils.i("loadState $state")
            }
            lifecycleScope.launchWhenCreated {
                studiedList().asFlow().collectLatest { data ->
                    adapter.submitData(lifecycle, data)
                }
            }
        }
    }
}