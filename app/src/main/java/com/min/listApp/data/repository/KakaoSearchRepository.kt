package com.min.listApp.data.repository

import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.repository.base.BaseRepository
import io.reactivex.Single

interface KakaoSearchRepository : BaseRepository {
    fun search(
        category: String,
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 10 //1-80 사이 Integer
    ): Single<KakaoSearchEntity>
}