package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
data class DataX(
        var addWatermark: Boolean,
        var area: String,
        var checkStatus: String,
        var city: String,
        var collected: Boolean,
        var consumption: Consumption,
        var cover: Cover,
        var createTime: Long,
        var dataType: String,
        var description: String,
        var height: Int,
        var id: Int,
        var ifMock: Boolean,
        var latitude: Int,
        var library: String,
        var longitude: Int,
        var owner: Owner,
        var playUrl: String,
        var duration: Int,
        var privateMessageActionUrl: Any,
        var reallyCollected: Boolean,
        var recentOnceReply: RecentOnceReply,
        var releaseTime: Long,
        var resourceType: String,
        var selectedTime: Long,
        var status: Int,
        var tags: List<Tag>,
        var title: String,
        var uid: Int,
        var updateTime: Long,
        var url: String,
        var urls: List<String>,
        var urlsWithWatermark: List<String>,
        var varidateResult: String,
        var varidateStatus: String,
        var width: Int
)