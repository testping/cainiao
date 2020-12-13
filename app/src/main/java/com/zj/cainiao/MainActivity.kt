package com.zj.cainiao

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.zj.cainiao.databinding.ActivityMainBinding
import com.zj.common.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initConfig() {
        super.initConfig()
    }

    override fun initView() {
        super.initView()
        val navController = findNavController(R.id.fcv_main)
        dataBinding?.run {
            bnvMain.setupWithNavController(navController)
        }
    }

    override fun initData() {
        super.initData()
    }

}