package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity
import io.reactivex.Single

object KakaoSearchCache : KakaoSearchDataSource<Single<KakaoSearchEntity>> {
    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Single<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}