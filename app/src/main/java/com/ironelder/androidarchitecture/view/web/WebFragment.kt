package com.ironelder.androidarchitecture.view.web

import android.os.Bundle
import androidx.databinding.Observable
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.WEB_TAB
import com.ironelder.androidarchitecture.common.showToastMessage
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.databinding.FragmentWebBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class WebFragment :
    BaseFragment<FragmentWebBinding>(R.layout.fragment_web) {

    override fun initializedView(savedInstanceState: Bundle?) {
        binding.webViewModel = WebViewModel(NetworkUseCase())
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
        binding.webViewModel?.let {
            it.searchData(WEB_TAB, "test")
            it.errorMessage.addOnPropertyChangedCallback(object :
                Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    activity?.showToastMessage(it.errorMessage.get() ?: "Error")
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
