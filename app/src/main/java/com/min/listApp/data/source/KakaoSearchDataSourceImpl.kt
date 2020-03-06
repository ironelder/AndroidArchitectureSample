package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity

object KakaoSearchDataSourceImpl : KakaoSearchDataSource {

    val searchRemote: KakaoSearchRemote = KakaoSearchRemote
    val searchCache: KakaoSearchCache = KakaoSearchCache

    private fun getDataSource(query: String): KakaoSearchDataSource = if (useableCache(query)) searchCache else searchRemote

    //캐시 사용 여부를 반환, 캐시는 미구현이기에 우선 false
    private fun useableCache(query: String): Boolean = false

    override fun searchImage(
            query: String,
            sort: String,
            page: Int,
            size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )


    override fun searchWeb(
            query: String,
            sort: String,
            page: Int,
            size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

    override fun searchVideoClip(
            query: String,
            sort: String,
            page: Int,
            size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

    override fun searchBlog(
            query: String,
            sort: String,
            page: Int,
            size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

    override fun searchTip(
            query: String, sort: String, page: Int, size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

    override fun searchBook(
            query: String,
            sort: String,
            page: Int,
            size: Int,
            target: String
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

    override fun searchKeyword(
            query: String,
            sort: String,
            page: Int,
            size: Int
    ): KakaoSearchEntity = getDataSource(query = query).searchImage(
            query = query,
            sort = sort,
            page = page,
            size = size
    )

}