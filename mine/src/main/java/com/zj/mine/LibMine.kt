package com.zj.mine

import com.zj.common.network.KtRetrofit
import com.zj.common.network.config.BASE_URL
import com.zj.mine.net.UserInfoService
import com.zj.mine.repo.IUserInfoResource
import com.zj.mine.repo.UserInfoRepo
import com.zj.mine.ui.MineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * mine模块相关的Koin module配置
 */
val moduleMine: Module = module {

    single {
        KtRetrofit.initConfig(BASE_URL)
            .getService(UserInfoService::class.java)
    }

    single {
        UserInfoRepo(get())
    } bind IUserInfoResource::class

    viewModel {
        MineViewModel(get())
    }
}