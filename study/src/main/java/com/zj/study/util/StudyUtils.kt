package com.zj.study.util

import androidx.databinding.BindingAdapter
import com.daimajia.numberprogressbar.NumberProgressBar

object StudyUtils {

    @JvmStatic
    fun rankStr(rank: Int): String {
        return if (rank > 0) "第${rank}名" else "千里之外"
    }

}

@BindingAdapter("app:progress_current", requireAll = false)
fun setProgress(pb: NumberProgressBar, progress: Double?) {
    pb.progress = ((progress ?: 0.0) * 100).toInt()
}