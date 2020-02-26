package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.Document
import com.ironelder.androidarchitecture.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
    BaseActivity<MainContract.View, MainContract.Presenter>(R.layout.activity_main),
    MainContract.View {
    override val presenter = MainPresenter()

    override fun onDataChanged(result: List<Document>?) {
        (rv_searchList.adapter as? SearchListAdapter)?.setDocumentData(result)
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun initializedView(savedInstanceState: Bundle?) {
        rv_searchList.apply {
            adapter =
                SearchListAdapter()
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = linearLayoutManager
        }
        presenter.searchData("blog", "test")
    }
}
