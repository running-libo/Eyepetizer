package com.example.base.network.databinding

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.utils.ScreenUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
object BindingAdapterUtil {

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
    fun resize(imageView: ImageView, widthHeight: Array<Int>) {
        var realWidth = (ScreenUtils.getScreenWidth(imageView.context)-ScreenUtils.dp2px(imageView.context, 32.0f))/2
        var layoutParams: ViewGroup.LayoutParams = imageView.layoutParams
        layoutParams.width = realWidth
        layoutParams.height = (realWidth.toFloat()/widthHeight[0]*widthHeight[1]).toInt()
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