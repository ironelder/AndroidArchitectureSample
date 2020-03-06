package com.min.listApp.data.source

interface KakaoSearchDataSource<T> {
    fun search(
        category: String, //카테고리
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 80 //1-80 사이 Integer
    ): T
}