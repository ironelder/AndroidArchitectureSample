package com.min.listApp.data.source

import com.min.listApp.data.source.call.KakaoDataSourceCallable


object KakaoSearchDataSourceImpl : KakaoSearchDataSource<KakaoDataSourceCallable> {

    val searchRemote: KakaoSearchDataSource<KakaoDataSourceCallable> = KakaoSearchRemote
    val searchCache: KakaoSearchDataSource<KakaoDataSourceCallable> = KakaoSearchCache

    private fun getCallSource(
        category: String,
        query: String
    ): KakaoSearchDataSource<KakaoDataSourceCallable> =
        if (useableCache(category = category, query = query)) searchCache else searchRemote

    //캐시 사용 여부를 반환, 캐시는 미구현이기에 우선 false
    private fun useableCache(category: String, query: String): Boolean = false

    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): KakaoDataSourceCallable = getCallSource(category = category, query = query).search(
        category = category,
        query = query,
        sort = sort,
        page = page,
        size = size
    )
}