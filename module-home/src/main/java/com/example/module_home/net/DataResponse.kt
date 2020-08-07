package com.example.module_home.net

import com.example.base.network.base.response.BaseResponse

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
class DataResponse : BaseResponse<Any?>() {

    var count = 0
    var total = 0
    var nextPageUrl: String? = null
    var isAdExist = false
    var itemList: List<ItemListBean>? = null

    class ItemListBean {

        var type: String? = null
        var data: DataBean? = null
        var tag: Any? = null
        var id = 0
        var adIndex = 0

        class DataBean {

            var dataType: String? = null
            var id = 0
            var title: String? = null
            var joinCount = 0
            var viewCount = 0
            var isShowHotSign = false
            var actionUrl: String? = null
            var imageUrl: String? = null
            var isHaveReward = false
            var isIfNewest = false
            var newestEndTime: Long = 0

        }
    }
}