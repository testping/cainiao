package com.zj.common.network.support

/**
 * 网络请求的接口回调
 */
interface IHttpCallback {

    /**
     * 网络请求成功的回调
     * [data] 返回回调的数据结果
     * @param data 返回回调的数据结果
     */
    fun onSuccess(data: Any?)


    /**
     * 接口回调失败
     * [error] 错误信息的数据类
     */
    fun onFailed(error: Any?)

}

/**
 * 网络请求回调
 */
interface IHttpCallback {

    /**
     * 请求成功
     * [data] 请求到的数据
     */
    fun onSuccess(data: Any?)

    /**
     * 请求失败
     */
    fun onFailed(data: Any?)
}