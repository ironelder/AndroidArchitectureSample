package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.util.Log
import android.view.View
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentWebBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class WebFragment :
    BaseFragment<WebContract.View, WebContract.Presenter, FragmentWebBinding>(R.layout.fragment_web),
    WebContract.View {
    override fun onDataChanged(result: List<ListItem>?) {
        Log.d("ironelderLog", "onDataChanged")
        binding.items = result
    }

    override fun showErrorMessage(message: String) {
        Log.d("ironelderLog", "showErrorMessage")
    }

    override fun showLoading() {
        Log.d("ironelderLog", "showLoading")
    }

    override fun hideLoading() {
        Log.d("ironelderLog", "hideLoading")
    }

    override val presenter = WebPresenter(NetworkUseCase())

    override fun initializedView(savedInstanceState: Bundle?){
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
        presenter.searchData("blog", "test")
    }
}
