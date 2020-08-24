package com.example.base.network.databinding

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.base.network.utils.ScreenUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
object BindingAdapterUtil {

    @JvmStatic
    @BindingAdapter(value = ["imgUrl"], requireAll = true)
    fun setImgUrl(imageView: ImageView, url: String?) {

        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }

    /**
     * 由时间戳转日期格式
     */
    @JvmStatic
    @BindingAdapter(value = ["timestamp"], requireAll = false)
    fun timeStamp2Date(textView: TextView, timestamp: Long) {
        var sdf = SimpleDateFormat("YYYY/mm/dd")
        val date = Date(timestamp)
        textView.setText(sdf.format(date) + " 发布：")
    }

    /**
     * 由宽高值算Imageview实际高度
     */
    @JvmStatic
    @BindingAdapter(value = ["widthHeight"], requireAll = false)
    fun resize(imageView: ImageView, widthHeight: Array<Int>?) {

        var realWidth = (ScreenUtils.getScreenWidth(imageView.context)-ScreenUtils.dp2px(imageView.context, 32.0f))/2
        var layoutParams: ViewGroup.LayoutParams = imageView.layoutParams
        layoutParams.width = realWidth
        layoutParams.height = (realWidth.toFloat()/ (widthHeight?.get(0) ?: 100) * (widthHeight?.get(1) ?: 100)).toInt()
        imageView.layoutParams = layoutParams
    }

    /**
     * 给view设置点击跳转页面
     */
    @JvmStatic
    @BindingAdapter(value = ["jumpPage"], requireAll = false)
    fun jumpPage(view: View, routePath: String) {
        view.setOnClickListener {
            ARouter.getInstance().build(routePath).navigation()
        }
    }
}