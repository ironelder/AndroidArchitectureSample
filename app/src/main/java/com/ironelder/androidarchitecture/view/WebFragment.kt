package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.widget.Toast
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.BLOG_TAB
import com.ironelder.androidarchitecture.common.showToastMessage
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentWebBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class WebFragment :
    BaseFragment<WebContract.View, WebContract.Presenter, FragmentWebBinding>(R.layout.fragment_web),
    WebContract.View {
    override fun onDataChanged(result: List<ListItem>?) {
        binding.items = result
    }

    override fun showErrorMessage(message: String) {
        activity?.showToastMessage(message, Toast.LENGTH_SHORT)
    }

    override fun showLoading() {
        binding.isLoading = true
    }

    override fun hideLoading() {
        binding.isLoading = false
    }

    override val presenter = WebPresenter(NetworkUseCase())

    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
        presenter.searchData(BLOG_TAB, "test")
    }
}
