package com.min.listApp.data.repository

import com.min.listApp.data.repository.base.BaseRepository

interface KakaoSearchRepository : BaseRepository {
    fun searchImage(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 80 //1-80 사이 Integer
    )

    fun searchWeb(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 10 //1-50 사이 Integer
    )

    fun searchVideoClip(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-15 사이 Integer
        size: Int = 15 //1-30 사이 Integer
    )

    fun searchBlog(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 10 //1-50 사이 Integer
    )

    fun searchTip(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-50 사이 Integer
        size: Int = 10 //1-50 사이 Integer
    )

    fun searchBook(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-100 사이 Integer
        size: Int = 10, //1-50 사이 Integer
        target: String //title (제목에서 검색) or isbn (ISBN에서 검색) or publisher (출판사에서 검색) or person(인명에서 검색)
    )

    fun searchKeyword(
        query: String, //검색을 원하는 질의어
        sort: String = "recency", //accuracy (정확도순) or recency (최신순)
        page: Int = 1, //1-100 사이 Integer
        size: Int = 10 //1-50 사이 Integer
    )
}