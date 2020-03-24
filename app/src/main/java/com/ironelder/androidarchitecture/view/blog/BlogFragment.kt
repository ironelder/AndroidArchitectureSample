package com.ironelder.androidarchitecture.view.blog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.BLOG_TAB
import com.ironelder.androidarchitecture.common.CAFE_TAB
import com.ironelder.androidarchitecture.common.showToastMessage
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentBlogBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment
import com.ironelder.androidarchitecture.view.cafe.CafePresenter

class BlogFragment :
BaseFragment<BlogContract.View, BlogContract.Presenter, FragmentBlogBinding>(R.layout.fragment_blog),
    BlogContract.View {
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
        BlogPresenter(
            NetworkUseCase()
        )

    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = com.ironelder.androidarchitecture.component.SearchListAdapter()
        }
        presenter.searchData(BLOG_TAB, "아이유")
    }
}
