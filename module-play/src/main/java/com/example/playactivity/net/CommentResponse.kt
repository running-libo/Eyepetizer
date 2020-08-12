package com.example.playactivity.net

import com.example.base.network.base.response.BaseResponse

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
data class CommentResponse(var itemList: List<CommentData>) : BaseResponse() {

    data class CommentData(
            val adIndex: Int,
            val `data`: Data,
            val id: Int,
            val tag: Any,
            val type: String
    )

    data class Data(
            val actionUrl: Any,
            val cover: Any,
            val createTime: Long,
            val dataType: String,
            val hot: Boolean,
            val id: Long,
            val imageUrl: String,
            val likeCount: Int,
            val liked: Boolean,
            val message: String,
            val parentReply: Any,
            val parentReplyId: Long,
            val replyStatus: String,
            val rootReplyId: Long,
            val sequence: Int,
            val showConversationButton: Boolean,
            val showParentReply: Boolean,
            val sid: String,
            val type: String,
            val ugcVideoId: Any,
            val ugcVideoUrl: Any,
            val user: User,
            val userBlocked: Boolean,
            val userType: Any,
            val videoId: Int,
            val videoTitle: String
    )

    data class User(
            val actionUrl: String,
            val area: Any,
            val avatar: String,
            val birthday: Any,
            val city: Any,
            val country: Any,
            val cover: Any,
            val description: Any,
            val expert: Boolean,
            val followed: Boolean,
            val gender: Any,
            val ifPgc: Boolean,
            val job: Any,
            val library: String,
            val limitVideoOpen: Boolean,
            val nickname: String,
            val registDate: Long,
            val releaseDate: Any,
            val uid: Int,
            val university: Any,
            val userType: String
    )
}