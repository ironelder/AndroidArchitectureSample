package com.min.listApp.data.repository

import com.min.listApp.data.source.KakaoSearchDataSourceImpl
import com.min.listApp.data.source.call.KakaoDataSourceCallable

object KakaoSearchRepositoryImpl : KakaoSearchRepository {

    val dataSource = KakaoSearchDataSourceImpl

    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int,
        response: KakaoSearchResponse,
        failure: KakaoSearchFailure
    ): KakaoDataSourceCallable {
        val call = dataSource.search(
            category = category,
            query = query,
            sort = sort,
            page = page,
            size = size
        )
        call.errorCallback = failure
        call.succeedCallback = response

        return call
    }
}