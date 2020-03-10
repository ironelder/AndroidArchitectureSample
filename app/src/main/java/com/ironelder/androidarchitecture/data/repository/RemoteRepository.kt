package com.ironelder.androidarchitecture.data.repository

import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.model.DataModel
import retrofit2.Call

interface RemoteRepository {
    fun searchForKakao(
        category: String,
        query: String
    ) : Call<Contents>
}