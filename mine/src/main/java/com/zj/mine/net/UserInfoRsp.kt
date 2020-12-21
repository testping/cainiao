package com.zj.mine.net

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfoRsp(
    val company: String?,
    val desc: String?,
    val email: String?,
    val focus_it: String?,
    val follower_count: Int?,
    val following_count: Int?,
    val id: Int?,
    val job: String?,
    val logo_url: String?,
    val mobi: String?,
    val real_name: String?,
    val username: String?,
    val work_years: String?
) : Parcelable