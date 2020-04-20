package com.min.listApp.ui.view

import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.databinding.FragmentListWebBinding
import com.min.listApp.ui.base.BaseFragment
import com.min.listApp.ui.component.KakaoSearchListAdapter

class KakaoWebSearchListFragment : BaseFragment<FragmentListWebBinding>(R.layout.fragment_list_web) {

//    override val presenter: ListFragmentConstract.Presenter = ListFragmentPresenter(this)

     fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>) {
        @Suppress("UNCHECKED_CAST")
        (binding.list.adapter as? KakaoSearchListAdapter)?.let {
            it.setData(listItemModels.filterIsInstance<KakaoImageListItemModel>())
        }
    }

    override fun initLayout() {
        binding.list.adapter = KakaoSearchListAdapter()
    }

    fun searchKakao(keyword: String){
//        presenter.searchKakao(keyword = keyword)
    }
}
