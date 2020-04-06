package com.ironelder.androidarchitecture.view.web

import android.os.Bundle
import android.util.Log
import androidx.databinding.Observable
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.common.WEB_TAB
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentWebBinding
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseFragment

class WebFragment :
    BaseFragment<WebViewModel, FragmentWebBinding>(R.layout.fragment_web){
    private val viewModel: WebViewModel = WebViewModel(NetworkUseCase())

    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
        viewModel.searchData(WEB_TAB,"test")
        viewModel.errorMessage.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("ironelderLog","sender= $sender , msg = ${viewModel.errorMessage.get()}")
            }
        })
    }
}
