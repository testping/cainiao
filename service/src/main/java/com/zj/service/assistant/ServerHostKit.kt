package com.zj.service.assistant

import android.content.Context
import com.didichuxing.doraemonkit.kit.AbstractKit
import com.zj.service.R

class ServerHostKit : AbstractKit() {
    override val icon: Int get() = R.drawable.icon_server_host

    override val name = R.string.str_server_host_dokit

    override fun onAppInit(context: Context?) {
    }

    override fun onClick(context: Context?) {
    }
}