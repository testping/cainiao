package com.zj.cainiao

import com.alibaba.android.arouter.launcher.ARouter
import com.zj.common.BaseApplication
import com.zj.common.ktx.application
import com.zj.login.moduleLogin
import com.zj.mine.moduleMine
import com.zj.service.assistant.AssistantApp
import com.zj.service.moduleService
import com.zj.study.moduleStudy
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

class CnApplication : BaseApplication() {

    private val modules = arrayListOf<Module>(moduleService, moduleMine, moduleLogin, moduleStudy)

    override fun initConfig() {
        super.initConfig()

        //doKit的初始化配置
        AssistantApp.initConfig(application)
        loadKoinModules(modules)
        ARouter.init(application)
    }
}