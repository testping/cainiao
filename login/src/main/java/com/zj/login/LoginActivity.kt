package com.zj.login

import com.blankj.utilcode.util.ToastUtils
import com.zj.common.base.BaseActivity
import com.zj.login.databinding.ActivityLoginBinding
import com.zj.login.net.RegisterRsp
import org.koin.androidx.viewmodel.ext.android.viewModel

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
                if (it.is_register == RegisterRsp.FLAG_IS_REGISTERED) {
                    repoLogin()
                }
            }

            liveLoginRsp.observerKt {
                ToastUtils.showShort("登录结果 $it")
            }
        }

    }
}