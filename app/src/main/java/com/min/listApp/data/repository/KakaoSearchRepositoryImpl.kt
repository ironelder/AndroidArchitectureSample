package com.min.listApp.data.repository

import com.min.listApp.data.source.KakaoSearchDataSource
import com.min.listApp.data.source.KakaoSearchDataSourceImpl

object KakaoSearchRepositoryImpl : KakaoSearchRepository {

    val dataSource: KakaoSearchDataSource = KakaoSearchDataSourceImpl

    override fun searchImage(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchWeb(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchVideoClip(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchBlog(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchTip(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchBook(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            target: String,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }

    override fun searchKeyword(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            response: KakaoSearchResponse,
            failure: KakaoSearchFailure
    ) {
        dataSource.searchImage(query = query, sort = sort, page = page, size = size)
    }


}