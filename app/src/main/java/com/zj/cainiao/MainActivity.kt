package com.zj.cainiao

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blankj.utilcode.util.LogUtils
import com.zj.network.HttpApi
import com.zj.network.IHttpCallback
import com.zj.network.OkHttpApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val map = mapOf(
            "key" to "free",
            "appid" to "0",
            "msg" to "你好呀，我想和你做朋友，可以吗，哈哈"
        )

        httpApi.get(map, "api.php", object : IHttpCallback {

            override fun onSuccess(data: Any?) {
                LogUtils.d("success result : ${data.toString()}")

            }

            override fun onFailed(error: Any?) {
                LogUtils.d("failed msg : ${error.toString()}")
            }


        })

        httpApi.post(loginBody,"",object:IHttpCallback{
            override fun onSuccess(data: Any?) {
                LogUtils.d("success result : ${data.toString()}")
                runOnUiThread {
                }
            }

            override fun onFailed(error: Any?) {
                LogUtils.d("failed msg : ${error.toString()}")
            }

        })
    }

    val loginBody = LoginReq()
    val httpApi: HttpApi = OkHttpApi()

    override fun onPause() {
        super.onPause()
//        httpApi.cancelAllRequest()
    }

    data class LoginReq(
        val mobi: String = "18648957777",
        val password: String = "cn5123456"
    )
}