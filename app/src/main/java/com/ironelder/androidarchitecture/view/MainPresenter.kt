package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.component.NetworkService
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.view.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {
    override fun searchData(category: String, query: String) {
        view?.apply {
            showLoading()
        }
        NetworkService.searchAPI.search(category, query).enqueue(object : Callback<DataModel>{
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                view?.apply {
                    showErrorMessage(t.message.toString())
                }
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                view?.apply {
                    onDataChanged(response.body()?.documents)
                    hideLoading()
                }
            }
        })
    }

    fun onFail(msg:String) {
    }

    fun onSuccess(result:DataModel) {
    }

}