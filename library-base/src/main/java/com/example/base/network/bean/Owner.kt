package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
data class Owner(
        var actionUrl: String,
        var area: Any,
        var avatar: String,
        var birthday: Long,
        var city: String,
        var country: String,
        var cover: String,
        var description: String,
        var expert: Boolean,
        var followed: Boolean,
        var gender: String,
        var ifPgc: Boolean,
        var job: String,
        var library: String,
        var limitVideoOpen: Boolean,
        var nickname: String,
        var registDate: Long,
        var releaseDate: Long,
        var uid: Int,
        var university: String,
        var userType: String
)