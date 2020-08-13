package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
data class Detail(
        val actionUrl: String,
        val adTrack: List<AdTrack>,
        val adaptiveImageUrls: String,
        val adaptiveUrls: String,
        val canSkip: Boolean,
        val categoryId: Int,
        val countdown: Boolean,
        val cycleCount: Int,
        val description: String,
        val displayCount: Int,
        val displayTimeDuration: Int,
        val icon: String,
        val id: Int,
        val ifLinkage: Boolean,
        val imageUrl: String,
        val iosActionUrl: String,
        val linkageAdId: Int,
        val loadingMode: Int,
        val openSound: Boolean,
        val position: Int,
        val showActionButton: Boolean,
        val showImage: Boolean,
        val showImageTime: Int,
        val timeBeforeSkip: Int,
        val title: String,
        val url: String,
        val videoAdType: String,
        val videoType: String
)

data class AdTrack(
        val clickUrl: String,
        val monitorPositions: String,
        val needExtraParams: List<String>,
        val organization: String,
        val playUrl: String,
        val viewUrl: String
)