package com.min.listApp.data.source

import com.min.listApp.data.entity.KakaoSearchEntity

object KakaoSearchRemote: KakaoSearchDataSource {
    override fun searchImage(query: String, sort: String, page: Int, size: Int): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchWeb(query: String, sort: String, page: Int, size: Int): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchVideoClip(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchBlog(query: String, sort: String, page: Int, size: Int): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchTip(query: String, sort: String, page: Int, size: Int): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchBook(
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String
    ): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchKeyword(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): KakaoSearchEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}