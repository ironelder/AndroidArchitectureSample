package com.min.listApp.data.repository

import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.source.KakaoSearchDataSourceImpl
import io.reactivex.Single

object KakaoSearchRepositoryImpl : KakaoSearchRepository {

    val dataSource = KakaoSearchDataSourceImpl

    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Single<KakaoSearchEntity> {
        val call = dataSource.search(
            category = category,
            query = query,
            sort = sort,
            page = page,
            size = size
        )

        return call
    }
}