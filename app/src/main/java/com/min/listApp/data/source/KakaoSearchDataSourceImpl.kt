package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity
import io.reactivex.Single


object KakaoSearchDataSourceImpl : KakaoSearchDataSource<Single<KakaoSearchEntity>> {

    val searchRemote: KakaoSearchDataSource<Single<KakaoSearchEntity>> = KakaoSearchRemote
    val searchCache: KakaoSearchDataSource<Single<KakaoSearchEntity>> = KakaoSearchCache

    private fun getCallSource(
        category: String,
        query: String
    ): KakaoSearchDataSource<Single<KakaoSearchEntity>> =
        if (useableCache(category = category, query = query)) searchCache else searchRemote

    //캐시 사용 여부를 반환, 캐시는 미구현이기에 우선 false
    private fun useableCache(category: String, query: String): Boolean = false

    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Single<KakaoSearchEntity> = getCallSource(category = category, query = query).search(
        category = category,
        query = query,
        sort = sort,
        page = page,
        size = size
    )
}