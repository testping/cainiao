package com.zj.study.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.blankj.utilcode.util.LogUtils
import com.zj.common.network.support.serverData
import com.zj.service.network.onBizError
import com.zj.service.network.onBizOK
import com.zj.service.network.onFailure
import com.zj.service.network.onSuccess
import com.zj.study.net.BoughtRsp
import com.zj.study.net.StudiedRsp
import com.zj.study.net.StudyInfoRsp
import com.zj.study.net.StudyService
import com.zj.study.repo.data.BoughtItemPagingSource
import com.zj.study.repo.data.StudyItemPagingSource
import com.zj.study.ui.StudyViewMode
import kotlinx.coroutines.flow.Flow

class StudyRepo(private val service: StudyService) : IStudyResource {

    private val _studyInfo = MutableLiveData<StudyInfoRsp>()

    override val liveStudyInfo: LiveData<StudyInfoRsp> = _studyInfo

    private val pageSize = 10//页码大小

    override suspend fun getStudyInfo() {
        service.getStudyInfo().serverData()
            .onSuccess {
                onBizError { code, message ->
                    LogUtils.w("获取学习信息 BizError $code,$message")
                }
                onBizOK<StudyInfoRsp> { _, data, _ ->
                    _studyInfo.value = data
                    return@onBizOK
                }
            }
            .onFailure {
                LogUtils.e("获取学习信息 接口异常 ${it.message}")
            }
    }

    override suspend fun getStudyList(): Flow<PagingData<StudiedRsp.Data>> {
        val config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = 5,
            initialLoadSize = 10,
            maxSize = pageSize * 3
        )
        return Pager(config = config, null) {
            StudyItemPagingSource(service)
        }.flow
    }

    override suspend fun getBoughtCourse(): Flow<PagingData<BoughtRsp.Data>> {
        val config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = 5,
            initialLoadSize = 10,
            maxSize = pageSize * 3
        )
        return Pager(config = config, null) {
            BoughtItemPagingSource(service)
        }.flow
    }
}