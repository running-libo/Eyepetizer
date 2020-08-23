package com.example.base.network.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
object BindingAdapterUtil {

    @JvmStatic
    @BindingAdapter(value = ["timestamp"], requireAll = false)
    fun timeStamp2Date(textView: TextView, timestamp: Long) {
        var sdf = SimpleDateFormat("YYYY/mm/dd")
        val date = Date(timestamp)
        textView.setText(sdf.format(date) + " 发布：")
    }

}