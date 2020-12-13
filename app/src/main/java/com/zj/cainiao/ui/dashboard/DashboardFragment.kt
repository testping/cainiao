package com.zj.cainiao.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import com.zj.cainiao.R

class DashboardFragment : Fragment() {

    val viewModel: DashboardViewModel by viewModels {
        defaultViewModelProviderFactory
    }

    val viewModel1: DashboardViewModel by ViewModelLazy(DashboardViewModel::class,
        { viewModelStore },
        { defaultViewModelProviderFactory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)

        return root

    }
}