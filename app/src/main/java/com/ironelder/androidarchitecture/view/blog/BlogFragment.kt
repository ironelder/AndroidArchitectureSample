package com.ironelder.androidarchitecture.view.blog

import android.os.Bundle
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentBlogBinding
import com.ironelder.androidarchitecture.view.base.BaseFragment

class BlogFragment :
    BaseFragment<BlogViewModel, FragmentBlogBinding>(R.layout.fragment_blog) {
    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
    }
}
