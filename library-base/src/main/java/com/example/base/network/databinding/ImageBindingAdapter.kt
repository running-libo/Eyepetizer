package com.example.base.network.databinding

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * create by apple
 * create on 2020/8/10
 * description 图片加载工具
 */
object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["imgUrl"], requireAll = true)
    fun setImgUrl(imageView: ImageView, url: String?) {

        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}