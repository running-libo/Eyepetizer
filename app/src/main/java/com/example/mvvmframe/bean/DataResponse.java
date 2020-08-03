package com.example.mvvmframe.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
public class DataResponse extends BaseModel {

    /**
     * itemList : [{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":361,"title":"哪句话，支撑你度过许多让人煎熬时刻？","joinCount":567,"viewCount":2989,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=361","imageUrl":"http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597585947000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":360,"title":"如果完全按照父母对你规划发展，你现在的生活会是什么样？","joinCount":339,"viewCount":3152,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=360","imageUrl":"http://img.kaiyanapp.com/e841ea4ecea3054c7db09756241e0ece.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597496182000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":359,"title":"福利贴｜脑洞剧场：用 10 个字，写一个恐怖微小说","joinCount":1169,"viewCount":7504,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=359","imageUrl":"http://img.kaiyanapp.com/ec6bb60e988b53b3652fec7bbb645bc5.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597318800000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":358,"title":"在生活中，你遭受过哪些「性别歧视」？","joinCount":383,"viewCount":4242,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=358","imageUrl":"http://img.kaiyanapp.com/b50ee4719b04e0de23dfe14eecbabc9c.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597933094000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":357,"title":"影视剧或电影中，有哪些想让你按头大骂的「人设」？","joinCount":393,"viewCount":4796,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=357","imageUrl":"http://img.kaiyanapp.com/ab9025742da25417d2ce92e335a9f643.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596624810000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":356,"title":"一人安利一支乐队｜有哪些乐队你认为值得去听的？","joinCount":780,"viewCount":7574,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=356","imageUrl":"http://img.kaiyanapp.com/12ff9cfcf9e62935bacac91f25ad3c33.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":0},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":355,"title":"有哪些一读就会惊叹 「哇，好温柔啊」的句子？","joinCount":2168,"viewCount":13237,"showHotSign":true,"actionUrl":"eyepetizer://topic/detail?id=355","imageUrl":"http://img.kaiyanapp.com/1b6998b1d9392be605406cbd161eb9e5.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596204648000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":354,"title":"福利帖｜脑洞剧场：以「看到他发了朋友圈后，我知道他死了」开始","joinCount":1633,"viewCount":11781,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=354","imageUrl":"http://img.kaiyanapp.com/fa80560217789bb2f83e30414db406b2.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596195512000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":353,"title":"人生回答机｜20 岁的你，想对 30 岁的你说些什么？","joinCount":1786,"viewCount":13398,"showHotSign":true,"actionUrl":"eyepetizer://topic/detail?id=353","imageUrl":"http://img.kaiyanapp.com/72a3a238324297962cd27a8768dc9050.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1596109511000},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfTopic","data":{"dataType":"SquareTopicCard","id":352,"title":"迷惑事件大赏｜那些让你？？？？？？？？？？？？的奇奇怪怪事件","joinCount":734,"viewCount":8903,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=352","imageUrl":"http://img.kaiyanapp.com/bcbb97a058981a54d8168c18a01e696f.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1595417821000},"tag":null,"id":0,"adIndex":-1}]
     * count : 10
     * total : 0
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v7/topic/list?start=10&num=10
     * adExist : false
     */

    private List<ItemListBean> itemList;

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : squareCardOfTopic
         * data : {"dataType":"SquareTopicCard","id":361,"title":"哪句话，支撑你度过许多让人煎熬时刻？","joinCount":567,"viewCount":2989,"showHotSign":false,"actionUrl":"eyepetizer://topic/detail?id=361","imageUrl":"http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg","haveReward":true,"ifNewest":true,"newestEndTime":1597585947000}
         * tag : null
         * id : 0
         * adIndex : -1
         */

        private String type;
        @SerializedName("data")
        private DataBean data;
        private Object tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public static class DataBean {
            /**
             * dataType : SquareTopicCard
             * id : 361
             * title : 哪句话，支撑你度过许多让人煎熬时刻？
             * joinCount : 567
             * viewCount : 2989
             * showHotSign : false
             * actionUrl : eyepetizer://topic/detail?id=361
             * imageUrl : http://img.kaiyanapp.com/23ae9a35b18a5adefd908aeedfccf8aa.jpeg?imageMogr2/quality/60/format/jpg
             * haveReward : true
             * ifNewest : true
             * newestEndTime : 1597585947000
             */

            private String dataType;
            private int id;
            private String title;
            private int joinCount;
            private int viewCount;
            private boolean showHotSign;
            private String actionUrl;
            private String imageUrl;
            private boolean haveReward;
            private boolean ifNewest;
            private long newestEndTime;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getJoinCount() {
                return joinCount;
            }

            public void setJoinCount(int joinCount) {
                this.joinCount = joinCount;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public boolean isShowHotSign() {
                return showHotSign;
            }

            public void setShowHotSign(boolean showHotSign) {
                this.showHotSign = showHotSign;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public boolean isHaveReward() {
                return haveReward;
            }

            public void setHaveReward(boolean haveReward) {
                this.haveReward = haveReward;
            }

            public boolean isIfNewest() {
                return ifNewest;
            }

            public void setIfNewest(boolean ifNewest) {
                this.ifNewest = ifNewest;
            }

            public long getNewestEndTime() {
                return newestEndTime;
            }

            public void setNewestEndTime(long newestEndTime) {
                this.newestEndTime = newestEndTime;
            }
        }
    }
}
