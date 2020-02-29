package com.ironelder.androidarchitecture.data.repository

import com.ironelder.androidarchitecture.data.model.DataModel

interface RemoteRepository {
    fun searchForKakao(
        category: String,
        query: String,
        success: (result: DataModel) -> Unit,
        failed: (message: String) -> Unit
    )
}