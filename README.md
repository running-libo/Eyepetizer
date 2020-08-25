# Eyepetizer
Kotlin+Mvvm+Jetpack仿开眼App

这个项目是模仿开眼App的开源项目，App的页面色彩简单但非常有设计感，个人特别喜欢播放详情页面，加上背景高斯模糊之后非常高大上。该项目从技术上很大程度上是在考验开发者多套布局的能力。

####国际惯例，先上效果图
![首页](https://upload-images.jianshu.io/upload_images/8669504-62b157ac88e247d0.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

![社区](https://upload-images.jianshu.io/upload_images/8669504-c7b1c37193daa166.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

![播放页](https://upload-images.jianshu.io/upload_images/8669504-58f4c0872949e103.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)


![登录](https://upload-images.jianshu.io/upload_images/8669504-1e1ff95b34403dbd.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

![我的](https://upload-images.jianshu.io/upload_images/8669504-5f76ed298de2932e.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)



####[Github代码地址](https://github.com/18380438200/Eyepetizer)


####项目结构
项目采用的是Kotlin + 组件化 + MVVM + Jetpack 组件为项目架构。
![](https://upload-images.jianshu.io/upload_images/8669504-8c1b9cb39795ae8b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)



####设计图
设计图来自用于原版App的各页面截屏
![](https://upload-images.jianshu.io/upload_images/8669504-8ef0d0a367568227.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

####项目引用库
```
    //Kotlin
    api "androidx.core:core-ktx:+"
    api "androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0"
    api "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    //MVVM
    api 'androidx.lifecycle:lifecycle-extensions:2.0.0'
    api 'androidx.lifecycle:lifecycle-viewmodel:2.0.0'
    api 'androidx.lifecycle:lifecycle-livedata:2.0.0'

    //ARouter
    api 'com.alibaba:arouter-api:1.2.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.2'

    //Rxjava
    api 'io.reactivex:rxjava:1.1.0'
    api 'io.reactivex:rxandroid:1.1.0'

    //Retrofit
    api 'com.squareup.retrofit2:retrofit:2.0.0-beta4'
    api 'com.squareup.retrofit2:converter-gson:2.0.0-beta4'
    api 'com.squareup.retrofit2:adapter-rxjava:2.0.0-beta4'

    //Itembinding
    api 'me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:4.0.0'
    api 'me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:4.0.0'
    api 'me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-viewpager2:4.0.0'

    //Glide
    api 'com.github.bumptech.glide:glide:4.8.0'

    //Immersionbar  statusbarStyle
    api 'com.gyf.immersionbar:immersionbar:3.0.0-beta05'
    api 'com.gyf.immersionbar:immersionbar-components:3.0.0-beta05'

    //refresh/loadmore view
    api 'com.scwang.smartrefresh:SmartRefreshLayout:1.1.0'
    api 'com.scwang.smartrefresh:SmartRefreshHeader:1.1.0'

    //tablayout
    api 'com.androidkun:XTabLayout:1.1.5'

    //videoplayer
    api 'com.shuyu:GSYVideoPlayer:7.1.5'
```

####请求接口
##### 首页

1.发现

*   请求地址： [http://baobab.kaiyanapp.com/api/v7/index/tab/discovery](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv7%2Findex%2Ftab%2Fdiscovery)

2.推荐

*   请求地址： [http://baobab.kaiyanapp.com/api/v5/index/tab/allRec](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv5%2Findex%2Ftab%2FallRec)

3.日报

*   请求地址 ： [http://baobab.kaiyanapp.com/api/v5/index/tab/feed](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv5%2Findex%2Ftab%2Ffeed)

##### 社区

1.推荐
*   请求地址： [http://baobab.kaiyanapp.com/api/v7/community/tab/rec](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv7%2Fcommunity%2Ftab%2Frec)

2.关注
*   请求地址： [http://baobab.kaiyanapp.com/api/v6/community/tab/follow](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv6%2Fcommunity%2Ftab%2Ffollow)

##### 通知
1.主题

*   请求地址： [http://baobab.kaiyanapp.com/api/v7/tag/tabList](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv7%2Ftag%2FtabList)

2.通知

*   请求地址 ： [http://baobab.kaiyanapp.com/api/v3/messages](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv3%2Fmessages)

3.互动

*   请求地址 ： [http://baobab.kaiyanapp.com/api/v7/topic/list](https://links.jianshu.com/go?to=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv7%2Ftopic%2Flist)

#####视频播放
1.相关推荐
*   请求地址 ： [http://baobab.kaiyanapp.com/api/v4/video/related?id=%20211082](http://baobab.kaiyanapp.com/api/v4/video/related?id=%20211082)


2.视频评论
请求地址 ：[http://baobab.kaiyanapp.com/api/v2/replies/video?videoId=211050](http://baobab.kaiyanapp.com/api/v2/replies/video?videoId=211050)

项目会继续优化下去，喜欢的点个star吧。


