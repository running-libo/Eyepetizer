package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
data class Author(
        val adTrack: Any,
        val approvedNotReadyVideoCount: Int,
        val description: String,
        val expert: Boolean,
        val follow: Follow,
        val icon: String,
        val id: Int,
        val ifPgc: Boolean,
        val latestReleaseTime: Long,
        val link: String,
        val name: String,
        val recSort: Int,
        val shield: Shield,
        val videoNum: Int
)

data class Follow(
        val followed: Boolean,
        val itemId: Int,
        val itemType: String
)

data class Shield(
        val itemId: Int,
        val itemType: String,
        val shielded: Boolean
)