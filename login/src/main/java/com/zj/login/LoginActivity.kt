package com.zj.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.zj.common.base.BaseActivity
import com.zj.common.network.config.SP_KEY_USER_TOKEN
import com.zj.common.utils.CniaoSpUtils
import com.zj.login.databinding.ActivityLoginBinding
import com.zj.login.net.RegisterRsp
import com.zj.service.repo.CniaoDbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = "/login/login")
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun getLayoutId() = R.layout.activity_login

    override fun initView() {
        super.initView()
        dataBinding?.apply {
            vm = loginViewModel
            mtoolbarLogin.setNavigationOnClickListener { finish() }
        }
    }

    override fun initConfig() {
        super.initConfig()
        loginViewModel.apply {
            liveRegisterRsp.observerKt {
                if (it?.is_register == RegisterRsp.FLAG_IS_REGISTERED) {
                    repoLogin()
                }
            }

            liveLoginRsp.observerKt {
                it?.run {
                    CniaoDbHelper.insertUserInfo(this@LoginActivity, it)
                    CniaoSpUtils.put(SP_KEY_USER_TOKEN, it.token)
                    finish()
                }
            }
        }

    }
}