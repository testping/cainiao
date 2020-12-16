package com.zj.cainiao

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zj.cainiao.databinding.ActivityMainBinding
import com.zj.common.base.BaseActivity
import com.zj.common.widget.BnvMediator
import com.zj.course.CourseFragment
import com.zj.home.HomeFragment
import com.zj.mine.MineFragment
import com.zj.study.StudyFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val fragments = mapOf(
        INDEX_HOME to HomeFragment(),
        INDEX_COURSE to CourseFragment(),
        INDEX_STUDY to StudyFragment(),
        INDEX_MINE to MineFragment()
    )

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initConfig() {
        super.initConfig()
    }

    override fun initView() {
        dataBinding?.apply {
            vp2Main.adapter = MainAdapter(this@MainActivity, fragments)
            BnvMediator(bnvMain, vp2Main, lifecycle) { _, vp2Main ->
                vp2Main.isUserInputEnabled = false
            }.attach()
        }
    }

    override fun initData() {
        super.initData()
    }

    companion object {
        const val INDEX_HOME = 0 // 首页home对应Vp2的索引位置
        const val INDEX_COURSE = 1 // 课程所对应的位置
        const val INDEX_STUDY = 2 // 学习中心
        const val INDEX_MINE = 3 // 我的
    }

}

class MainAdapter(fragmentActivity: FragmentActivity, private val fragments: Map<Int, Fragment>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position] ?: error("请确保fragments数据源和viewPager2的index匹配设置")
    }
}