package com.example.base.network.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * create by libo
 * create on 2018/11/14
 * description Glide图片加载工具类
 */
object ImageLoaderManager {

    /**
     * 默认加载方式
     */
    @JvmStatic
    @BindingAdapter(value = ["imageUrl"], requireAll = true)
    fun loadImage(imageView: ImageView, url: String?) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.context)
                    .load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2324854561,2638012123&fm=26&gp=0.jpg")
                    .into(imageView)
        }
    }

}