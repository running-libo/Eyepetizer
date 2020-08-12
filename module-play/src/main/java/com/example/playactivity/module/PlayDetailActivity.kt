package com.example.playactivity.module

import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.playactivity.R
import com.example.playactivity.databinding.ActivityPlayDetailBinding
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_play_detail.*

@Route(path = RoutePath.Play.PLAY_DETAIL_ACTIVITY)
class PlayDetailActivity : BaseMvvmActivity<ActivityPlayDetailBinding, PlayDetailViewModel>() {
    var orientationUtils: OrientationUtils? = null
    @Autowired
    @JvmField
    var videoId: Int = 0

    override fun setLayoutId(): Int = R.layout.activity_play_detail

    override fun init() {
        ARouter.getInstance().inject(this)

        viewModel.getPlayDetailData(videoId)
        viewModel.detailData.observe(this, Observer {
            initPlayer(viewModel.detailData.value!!.playUrl)
        })

        supportFragmentManager.beginTransaction().add(R.id.flRelate, RelateVideoFragment()).commit()
    }

    override fun statusBarColor(): Int = R.color.black

    override fun isDarkFont(): Boolean = false

    fun initPlayer(playUrl: String) {
        videoPlayer.setUp(playUrl, true, "")

        //增加title
        videoPlayer.getTitleTextView().setVisibility(View.VISIBLE)
        //设置返回键
        videoPlayer.getBackButton().setVisibility(View.VISIBLE)
        //设置旋转
        orientationUtils = OrientationUtils(this, videoPlayer)
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        videoPlayer.fullscreenButton.setOnClickListener { orientationUtils!!.resolveByClick() }
        //设置返回按键功能
        videoPlayer.backButton.setOnClickListener { onBackPressed() }
        //开始播放
        videoPlayer.startPlayLogic()
    }

    override fun onPause() {
        super.onPause()
        videoPlayer.onVideoPause()
    }

    override fun onResume() {
        super.onResume()
        videoPlayer.onVideoResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
        if (orientationUtils != null)
            orientationUtils!!.releaseListener()
    }

    override fun onBackPressed() {
        //先返回正常状态
        if (orientationUtils!!.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            videoPlayer.getFullscreenButton().performClick()
            return
        }
        //释放所有
        videoPlayer.setVideoAllCallBack(null)
        super.onBackPressed()
    }

}