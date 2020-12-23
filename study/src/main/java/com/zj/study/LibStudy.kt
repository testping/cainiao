package com.zj.study

import com.zj.common.network.KtRetrofit
import com.zj.common.network.config.BASE_URL
import com.zj.study.net.StudyService
import com.zj.study.repo.IStudyResource
import com.zj.study.repo.StudyRepo
import com.zj.study.ui.StudyViewMode
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleStudy = module {

    single {
        KtRetrofit.initConfig(BASE_URL)
            .getService(StudyService::class.java)
    }

    single {
        StudyRepo(get())
    } bind IStudyResource::class

    viewModel {
        StudyViewMode(get())
    }
}