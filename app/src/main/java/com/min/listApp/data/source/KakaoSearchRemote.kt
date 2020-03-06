package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.network.NetworkService
import com.min.listApp.data.source.call.KakaoDataSourceCallable
import com.min.listApp.data.source.call.KakaoRemoteCall
import retrofit2.Call

typealias KakaoSearchDataSourceCall = KakaoRemoteCall

fun Call<KakaoSearchEntity>.getCall(): KakaoRemoteCall {
    return KakaoRemoteCall(call = this)
}

object KakaoSearchRemote : KakaoSearchDataSource<KakaoDataSourceCallable> {
    override fun search(
        category: String,
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): KakaoSearchDataSourceCall = NetworkService.kakaoSearchAPI.search(
        category = category,
        keyword = query,
        sort = sort,
        page = page,
        size = size
    ).getCall()
}