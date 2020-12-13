package com.zj.common

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // koin注入框架初始化
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApplication)
        }

        initConfig()
        initData()
    }

    open fun initConfig() {

    }

    open fun initData() {

    }

}