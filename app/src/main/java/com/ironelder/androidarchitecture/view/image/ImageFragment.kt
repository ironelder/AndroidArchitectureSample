package com.ironelder.androidarchitecture.view.image

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.ViewModelProvider
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.IMAGE_TAB
import com.ironelder.androidarchitecture.common.showToastMessage
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentImageBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class ImageFragment :
    BaseFragment<FragmentImageBinding>(R.layout.fragment_image) {

    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
    }

}
