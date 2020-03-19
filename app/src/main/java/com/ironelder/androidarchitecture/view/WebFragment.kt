package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentWebBinding
import com.ironelder.androidarchitecture.view.base.BaseFragment

class WebFragment : BaseFragment<WebContract.View, WebContract.Presenter, FragmentWebBinding>(R.layout.fragment_web), WebContract.View {
    override fun onDataChanged(result: List<ListItem>?) {
    }

    override fun showErrorMessage(message: String) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override val presenter: WebContract.Presenter
        get() = TODO("Not yet implemented")
}
