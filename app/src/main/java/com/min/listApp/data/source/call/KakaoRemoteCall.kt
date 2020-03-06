package com.min.listApp.data.source.call

import com.min.listApp.data.entity.KakaoSearchEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KakaoRemoteCall(val call: Call<KakaoSearchEntity>) : KakaoDataSourceCallable() {
    override fun execute() {
        call.enqueue(object : Callback<KakaoSearchEntity> {
            override fun onFailure(call: Call<KakaoSearchEntity>, t: Throwable) {
                errorCallback?.let { t.message?.let(it) }
            }

            override fun onResponse(
                call: Call<KakaoSearchEntity>,
                response: Response<KakaoSearchEntity>
            ) {

                if (response.isSuccessful) {
                    succeedCallback?.let { response.body()?.let(it) }
                } else {
                    errorCallback?.let { response.message().let(it) }
                }

            }
        })
    }
}