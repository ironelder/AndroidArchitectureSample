package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.network.NetworkService
import io.reactivex.Single


object KakaoSearchRemote : KakaoSearchDataSource<Single<KakaoSearchEntity>> {
    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Single<KakaoSearchEntity> = NetworkService.kakaoSearchAPI.search(
        category = category,
        keyword = query,
        sort = sort,
        page = page,
        size = size
    )
}