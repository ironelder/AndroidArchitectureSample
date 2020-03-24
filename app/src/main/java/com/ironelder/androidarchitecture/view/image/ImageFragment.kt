package com.ironelder.androidarchitecture.view.image

import android.os.Bundle
import android.widget.Toast
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.IMAGE_TAB
import com.ironelder.androidarchitecture.common.showToastMessage
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentImageBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class ImageFragment :
    BaseFragment<ImageContract.View, ImageContract.Presenter, FragmentImageBinding>(R.layout.fragment_image),
    ImageContract.View {
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

    override val presenter =
        ImagePresenter(
            NetworkUseCase()
        )

    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
        presenter.searchData(IMAGE_TAB, "설현")
    }

}
