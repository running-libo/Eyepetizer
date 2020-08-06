package com.example.base.network.bean

import com.example.base.network.base.response.BaseResponse

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
class DataResponse : BaseResponse<Any?>() {
    /**
     * itemList : [{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":361,"title":"哪句话，支撑你度过许多让人煎熬时刻？","joinCount":766,"viewCount":4144,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=361","imageUrl":"http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597585947000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":360,"title":"如果完全按照父母对你规划发展，你现在的生活会是什么样？","joinCount":401,"viewCount":3666,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=360","imageUrl":"http://img.kaiyanapp.com/e841ea4ecea3054c7db09756241e0ece.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597496182000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":359,"title":"福利贴｜脑洞剧场：用 10 个字，写一个恐怖微小说","joinCount":1295,"viewCount":8119,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=359","imageUrl":"http://img.kaiyanapp.com/ec6bb60e988b53b3652fec7bbb645bc5.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597318800000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":358,"title":"在生活中，你遭受过哪些「性别歧视」？","joinCount":410,"viewCount":4554,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=358","imageUrl":"http://img.kaiyanapp.com/b50ee4719b04e0de23dfe14eecbabc9c.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597933094000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":357,"title":"影视剧或电影中，有哪些想让你按头大骂的「人设」？","joinCount":405,"viewCount":5031,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=357","imageUrl":"http://img.kaiyanapp.com/ab9025742da25417d2ce92e335a9f643.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596624810000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":356,"title":"一人安利一支乐队｜有哪些乐队你认为值得去听的？","joinCount":806,"viewCount":7914,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=356","imageUrl":"http://img.kaiyanapp.com/12ff9cfcf9e62935bacac91f25ad3c33.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":0},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":355,"title":"有哪些一读就会惊叹 「哇，好温柔啊」的句子？","joinCount":2229,"viewCount":13667,"showHotSign":true,"actionUrl":"eyepetizer://topic/detail?id=355","imageUrl":"http://img.kaiyanapp.com/1b6998b1d9392be605406cbd161eb9e5.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596204648000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":354,"title":"福利帖｜脑洞剧场：以「看到他发了朋友圈后，我知道他死了」开始","joinCount":1638,"viewCount":12004,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=354","imageUrl":"http://img.kaiyanapp.com/fa80560217789bb2f83e30414db406b2.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596195512000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":353,"title":"人生回答机｜20 岁的你，想对 30 岁的你说些什么？","joinCount":1794,"viewCount":13534,"showHotSign":true,"actionUrl":"eyepetizer://topic/detail?id=353","imageUrl":"http://img.kaiyanapp.com/72a3a238324297962cd27a8768dc9050.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596109511000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":352,"title":"迷惑事件大赏｜那些让你？？？？？？？？？？？？的奇奇怪怪事件","joinCount":735,"viewCount":9089,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=352","imageUrl":"http://img.kaiyanapp.com/bcbb97a058981a54d8168c18a01e696f.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1595417821000},"tag":null,"id":0,"adIndex":-1}]
     * count : 10
     * total : 0
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v7/topic/list?start=10&num=10
     * adExist : false
     */
    var count = 0
    var total = 0
    var nextPageUrl: String? = null
    var isAdExist = false
    var itemList: List<ItemListBean>? = null

    class ItemListBean {
        /**
         * type : squareCardOfTopic
         * data : {"dataType":"SquareTopicCard","id":361,"title":"哪句话，支撑你度过许多让人煎熬时刻？","joinCount":766,"viewCount":4144,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=361","imageUrl":"http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597585947000}
         * tag : null
         * id : 0
         * adIndex : -1
         */
        var type: String? = null
        var data: DataBean? = null
        var tag: Any? = null
        var id = 0
        var adIndex = 0

        class DataBean {
            /**
             * dataType : SquareTopicCard
             * id : 361
             * title : 哪句话，支撑你度过许多让人煎熬时刻？
             * joinCount : 766
             * viewCount : 4144
             * showHotSign : false
             * actionUrl : eyepetizer://topic/detail?id=361
             * imageUrl : http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg
             * haveReward : true
             * ifNewest : true
             * newestEndTime : 1597585947000
             */
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