package com.zj.mine.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.zj.common.model.SingleLiveData
import com.zj.common.network.support.serverData
import com.zj.common.network.support.serverRsp
import com.zj.mine.net.UserInfoRsp
import com.zj.mine.net.UserInfoService
import com.zj.service.network.onBizError
import com.zj.service.network.onBizOK
import com.zj.service.network.onFailure
import com.zj.service.network.onSuccess

class UserInfoRepo(private val userInfoService: UserInfoService) : IUserInfoResource {
    private val _liveUser = MutableLiveData<UserInfoRsp>()
    override val liveUser: LiveData<UserInfoRsp> = _liveUser

    override suspend fun getUserInfo(token: String?) {
        userInfoService.getUserInfo(token).serverData().onSuccess {
            onBizError { code, message ->
                _liveUser.value = null
                LogUtils.w("获取用户信息 BizError $code,$message")
            }
            onBizOK<UserInfoRsp> { code, data, message ->
                _liveUser.value = data
                LogUtils.i("获取用户信息 BizOK $data")
                return@onBizOK
            }
        }.onFailure {
            LogUtils.e("获取用户信息 接口异常 ${it.message}")
        }
    }
}