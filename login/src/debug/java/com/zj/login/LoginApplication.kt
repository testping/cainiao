package com.zj.login

import com.zj.common.BaseApplication
import com.zj.service.moduleService
import org.koin.core.context.loadKoinModules

class LoginApplication : BaseApplication() {

    override fun initConfig() {
        super.initConfig()
        loadKoinModules(moduleService)
        loadKoinModules(moduleLogin)
    }
}