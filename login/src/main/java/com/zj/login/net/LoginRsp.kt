package com.zj.login.net

import androidx.annotation.Keep

/**
 * 查询手机号是否注册
 */
@Keep
data class RegisterRsp(
    val is_register: Int = FLAG_UN_REGISTERED
) {
    companion object {
        const val FLAG_IS_REGISTERED = 1   // 已经注册
        const val FLAG_UN_REGISTERED = 0 // 未注册
    }
}

/**
 * 手机号密码登录
 */
@Keep
data class LoginRsp(
    val course_permission: Boolean,
    val token: String?,
    val user: User
) {
    @Keep
    data class User(
        val id: Int,//用户id
        val logo_url: String?,//用户头像
        val reg_time: String?,//用户注册时间
        val username: String?//用户名
    )
}