package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
data class PushBean(
    val actionUrl: String,
    val content: String,
    val date: Long,
    val icon: String,
    val id: Int,
    val ifPush: Boolean,
    val pushStatus: Int,
    val title: String,
    val uid: Any,
    val viewed: Boolean
)