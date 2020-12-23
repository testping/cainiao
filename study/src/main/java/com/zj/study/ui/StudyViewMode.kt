package com.zj.study.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.zj.common.base.BaseViewModel
import com.zj.service.repo.CniaoUserInfo
import com.zj.study.net.StudyInfoRsp
import com.zj.study.repo.IStudyResource

class StudyViewMode(private val resource: IStudyResource) : BaseViewModel() {

    //学习页面的数据
    val liveStudyInfo: LiveData<StudyInfoRsp> = resource.liveStudyInfo

    //用户基本信息，头像和名字
    val obUserInfo = ObservableField<CniaoUserInfo>()

    val adapter = StudyPageAdapter()

    fun getStudyData() = serverAwait {
        resource.getStudyInfo()
    }

    suspend fun studiedList() =
        resource.getStudyList().asLiveData(viewModelScope.coroutineContext).cachedIn(viewModelScope)

    suspend fun boughtList() = resource.getBoughtCourse().asLiveData().cachedIn(viewModelScope)
}