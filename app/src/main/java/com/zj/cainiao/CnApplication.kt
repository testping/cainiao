package com.zj.cainiao

import com.zj.common.BaseApplication
import com.zj.common.ktx.application
import com.zj.service.assistant.AssistantApp

class CnApplication : BaseApplication() {

    override fun initConfig() {
        super.initConfig()

        //doKit的初始化配置
        AssistantApp.initConfig(application)
    }
}