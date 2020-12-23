package com.zj.login

import com.zj.common.network.KtRetrofit
import com.zj.common.network.config.BASE_URL
import com.zj.login.net.LoginService
import com.zj.login.repo.ILoginResource
import com.zj.login.repo.LoginRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Service模块相关的Koin module配置
 */
val moduleLogin: Module = module {

    single {
        KtRetrofit.initConfig(BASE_URL)
            .getService(LoginService::class.java)
    }

    single {
        LoginRepo(get())
    } bind ILoginResource::class

    viewModel {
        LoginViewModel(get())
    }
}