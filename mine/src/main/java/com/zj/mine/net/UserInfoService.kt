package com.zj.mine.net

import com.zj.service.network.BaseCniaoRsp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface UserInfoService {

    @GET("member/userinfo")
    fun getUserInfo(@Header("token") token: String?): Call<BaseCniaoRsp>
}