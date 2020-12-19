package com.zj.login.repo

import androidx.lifecycle.LiveData
import com.zj.login.net.LoginReqBody
import com.zj.login.net.LoginRsp
import com.zj.login.net.RegisterRsp

interface ILoginResource {

    // 注册结果接口回调
    val registerRsp: LiveData<RegisterRsp>

    // 登录接口回调
    val loginRsp: LiveData<LoginRsp>

    /**
     * 校验手机号是否注册，合法
     */
    suspend fun checkRegister(mobi: String)

    /**
     * 手机号合法的基础上，调用登录，获取登录结果token
     */
    suspend fun requestLogin(body: LoginReqBody)

}