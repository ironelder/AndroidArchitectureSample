package com.ironelder.androidarchitecture.view.cafe

import android.os.Bundle
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.FragmentCafeBinding
import com.ironelder.androidarchitecture.view.base.BaseFragment

class CafeFragment :
    BaseFragment<CafeViewModel, FragmentCafeBinding>(R.layout.fragment_cafe){
    override fun initializedView(savedInstanceState: Bundle?) {
        with(binding.rvSearchList) {
            adapter = SearchListAdapter()
        }
    }
}
