package com.min.listApp.presenter

import android.util.Log
import com.min.listApp.model.Image
import com.min.listApp.model.ImageDocument
import com.min.listApp.model.SearchRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MainConstract {
    interface View: BaseView<MainPresenter>{
        fun updateList(documents: List<ImageDocument>)
    }

    interface Presenter: BasePresenter{
        fun search(keyword: String)
    }
}

class MainPresenter(var view: MainConstract.View): MainConstract.Presenter {

    override fun search(keyword: String) {
        SearchRetrofit.getService()
            .requestSearchImage(keyword = keyword, page = 1).enqueue(object:
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
    }

}