package com.zj.login.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.zj.common.model.SingleLiveData
import com.zj.common.network.support.serverData
import com.zj.login.net.LoginReqBody
import com.zj.login.net.LoginRsp
import com.zj.login.net.LoginService
import com.zj.login.net.RegisterRsp
import com.zj.service.network.onBizError
import com.zj.service.network.onBizOK
import com.zj.service.network.onFailure
import com.zj.service.network.onSuccess
import retrofit2.Callback

class LoginRepo(private val loginService: LoginService) : ILoginResource {
    private val _registerRsp = SingleLiveData<RegisterRsp>()
    private val _loginRsp = SingleLiveData<LoginRsp>()

    override val registerRsp: LiveData<RegisterRsp> = _registerRsp
    override val loginRsp: LiveData<LoginRsp> = _loginRsp

    override suspend fun checkRegister(mobi: String) {
        loginService.isRegister(mobi)
            .serverData()
            .onSuccess {
                onBizError { code, message ->
                    LogUtils.w("是否注册 BizError $code,$message")
                }
                onBizOK<RegisterRsp> { code, data, message ->
                    _registerRsp.value = data
                    LogUtils.w("是否注册 BizError $code,$message")
                    return@onBizOK
                }
            }
            .onFailure {
                LogUtils.e("是否注册 接口异常 ${it.message}")
            }
    }

    override suspend fun requestLogin(body: LoginReqBody) {
        loginService.login(body)
            .serverData()
            .onSuccess {
                //只要不是接口响应成功，
                onBizError { code, message ->
                    LogUtils.w("登录接口 BizError $code,$message")
                }
                onBizOK<LoginRsp> { code, data, message ->
                    _loginRsp.value = data
                    LogUtils.i("登录接口 BizOK $data")
                }
            }.onFailure {
                LogUtils.e("登录接口 异常 ${it.message}")
            }
    }
}