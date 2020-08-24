package com.example.base.network.bean

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
data class CommonItemBean(
        var adIndex: Int,
        var data: Data,
        var id: Int,
        var tag: Any,
        var type: String
)

data class Data(
        var adTrack: Any,
        var content: Content,
        var dataType: String,
        var header: Header,
        var text: String,
        var detail: Detail,
        var icon: String,
        var title: String,
        var description: String,
        var image: String
)

data class Content(
        var adIndex: Int,
        var `data`: DataX,
        var id: Int,
        var tag: Any,
        var type: String,
        var author: Author
)

data class Consumption(
        var collectionCount: Int,
        var realCollectionCount: Int,
        var replyCount: Int,
        var shareCount: Int
)

data class Cover(
        var blurred: String,
        var detail: String,
        var feed: String,
        var homepage: String,
        var sharing: Any
)

data class RecentOnceReply(
        var actionUrl: String,
        var contentType: Any,
        var dataType: String,
        var message: String,
        var nickname: String
)