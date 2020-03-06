package com.min.listApp.presentation.presenter

import android.util.Log
import com.min.listApp.data.model.Image
import com.min.listApp.data.network.NetworkService
import com.min.listApp.data.repository.KakaoSearchRepository
import com.min.listApp.data.repository.KakaoSearchRepositoryImpl
import com.min.listApp.presentation.constract.MainConstract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(override var view: MainConstract.View) :
    MainConstract.Presenter {
    val kakaoRepository: KakaoSearchRepository =
        KakaoSearchRepositoryImpl


    override fun search(keyword: String) {

        kakaoRepository.searchImage(query = keyword, page = 1)


        NetworkService.getService()
            .requestSearchImage(keyword = keyword, page = 1).enqueue(object :
                Callback<Image> {
                override fun onFailure(call: Call<Image>, t: Throwable) {
                    Log.e("MIN", "onFailure:${t.message}")
                }

                override fun onResponse(call: Call<Image>, response: Response<Image>) {
                    Log.e("MIN", "onResponse => ${response.isSuccessful}")
                    if (response.isSuccessful) {
                        val image = response.body()
                        Log.e("MIN", "===> ${image?.meta?.total_count}")

                        view.updateList(image?.documents!!)

                    } else {
                        Log.e("MIN", response.message())
                    }
                }

            })
    }

    override fun start() {
        view.initLayout()
        search("코로나")
    }

}