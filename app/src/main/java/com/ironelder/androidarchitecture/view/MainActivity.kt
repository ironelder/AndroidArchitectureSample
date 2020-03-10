package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.NetworkUseCase
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.ActivityMainBinding
import com.ironelder.androidarchitecture.view.base.BaseActivity

class MainActivity :
    BaseActivity<MainContract.View, MainContract.Presenter, ActivityMainBinding>(R.layout.activity_main),
    MainContract.View {
    override val presenter = MainPresenter(NetworkUseCase())

    override fun onDataChanged(result: List<ListItem>?) {
        Log.d("ironelderLog", "result = ${result.isNullOrEmpty().toString()} , itemSize = ${result?.size}")
        binding.items = result
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
//        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
//        pb_loading.visibility = View.GONE
    }

    override fun initializedView(savedInstanceState: Bundle?) {
        Log.d("ironelderLog", "initializedView ")
        with(binding.rvSearchList){
            adapter = SearchListAdapter()
        }
        Log.d("ironelderLog", "initializedView searchData")
        presenter.searchData("blog", "test")
    }
}
