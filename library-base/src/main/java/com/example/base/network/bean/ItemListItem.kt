package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/24
 * description  社区-推荐顶部滑动item
 */
data class ItemListItem(
        val adIndex: Int,
        val `data`: DataItem,
        val id: Int,
        val tag: Any,
        val type: String
)

data class DataItem(
        val actionUrl: String,
        val bgPicture: String,
        val dataType: String,
        val subTitle: String,
        val title: String
)