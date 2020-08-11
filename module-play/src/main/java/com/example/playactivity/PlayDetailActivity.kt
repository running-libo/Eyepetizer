package com.example.playactivity

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.playactivity.databinding.ActivityPlayDetailBinding

@Route(path = RoutePath.Play.PLAY_DETAIL_ACTIVITY)
class PlayDetailActivity : BaseMvvmActivity<ActivityPlayDetailBinding, PlayDetailViewModel>() {

    override fun setLayoutId(): Int = R.layout.activity_play_detail

    override fun init() {

    }

}