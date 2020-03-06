package com.min.listApp.data.source

import com.min.listApp.data.source.call.KakaoDataSourceCallable

object KakaoSearchCache : KakaoSearchDataSource<KakaoDataSourceCallable> {
    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): KakaoDataSourceCallable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}