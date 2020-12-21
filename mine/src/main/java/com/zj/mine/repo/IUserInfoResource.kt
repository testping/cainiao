package com.zj.mine.repo

import androidx.lifecycle.LiveData
import com.zj.mine.net.UserInfoRsp

interface IUserInfoResource {

    val liveUser: LiveData<UserInfoRsp>

    suspend fun getUserInfo(token:String?)
}