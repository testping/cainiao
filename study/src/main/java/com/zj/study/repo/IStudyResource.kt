package com.zj.study.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.zj.study.net.BoughtRsp
import com.zj.study.net.StudiedRsp
import com.zj.study.net.StudyInfoRsp
import kotlinx.coroutines.flow.Flow

interface IStudyResource {

    val liveStudyInfo: LiveData<StudyInfoRsp>

    /**
     * 用户学习情况
     */
    suspend fun getStudyInfo()

    /**
     * 获取用户最近学习列表
     */
    suspend fun getStudyList(): Flow<PagingData<StudiedRsp.Data>>

    /**
     * 获取用户购买课程
     */
    suspend fun getBoughtCourse():Flow<PagingData<BoughtRsp.Data>>
}