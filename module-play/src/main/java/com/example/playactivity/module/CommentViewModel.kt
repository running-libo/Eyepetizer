package com.example.playactivity.module

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.playactivity.R

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
class CommentViewModel(application: Application) : BasePageViewModel<String>(application) {

    override fun getItemLayoutId(): Int = R.layout.item_comment

    init {
        getComments()
    }

    fun getComments() {
        for (i in 0..6) {
            items.add("")
        }
    }

}