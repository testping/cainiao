package com.zj.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年09月26日 05:21
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 * 登录界面逻辑的viewModel
 */
class LoginViewModel : ViewModel() {

    //账号，密码 的observable 对象
    val obMobile = ObservableField<String>()
    val obPassword = ObservableField<String>()


    fun goLogin() {

    }

}