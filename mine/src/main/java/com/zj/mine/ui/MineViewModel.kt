package com.zj.mine.ui

import com.zj.common.base.BaseViewModel
import com.zj.mine.repo.IUserInfoResource

class MineViewModel(private val resource: IUserInfoResource) : BaseViewModel() {

    val liveUser = resource.liveUser

    fun getUserInfo(token: String?) = serverAwait {
        resource.getUserInfo(token)
    }
}