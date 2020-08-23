package com.example.module_notice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.base.network.base.fragment.BaseLazyloadFragment

class InteractionFragment : BaseLazyloadFragment() {
    override fun initView() {

    }

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_interaction, container, false)
    }

}