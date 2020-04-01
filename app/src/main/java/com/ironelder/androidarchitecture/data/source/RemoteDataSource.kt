package com.ironelder.androidarchitecture.data.source

import com.ironelder.androidarchitecture.data.entity.Contents
import io.reactivex.Single
import retrofit2.Call

interface RemoteDataSource {
    fun searchForKakao(category: String, query: String): Single<Contents>
}