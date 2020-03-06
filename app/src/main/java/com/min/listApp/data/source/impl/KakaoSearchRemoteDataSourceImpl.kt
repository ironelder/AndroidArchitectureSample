package com.min.listApp.data.source.impl

import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.source.KakaoSearchRemoteDataSource
import retrofit2.Call

class KakaoSearchRemoteDataSourceImpl : KakaoSearchRemoteDataSource {
    override fun searchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchWeb(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchVideoClip(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchBlog(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchTip(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchBook(
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchKeyword(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<KakaoSearchEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}