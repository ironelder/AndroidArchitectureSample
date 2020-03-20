package com.min.listApp.data.source.call

import com.min.listApp.data.entity.KakaoSearchEntity
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KakaoRemoteCall(val call: Single<KakaoSearchEntity>) : KakaoDataSourceCallable() {
    override fun execute() {
        call.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ entity ->
            succeedCallback?.let {
                it(entity)
            }
        }, {throwable ->
            errorCallback?.let { throwable.message?.let(it) }
        })
    }
}