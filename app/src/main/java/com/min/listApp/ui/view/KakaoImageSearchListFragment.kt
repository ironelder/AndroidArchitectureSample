package com.min.listApp.ui.view

import android.os.Bundle
import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.databinding.FragmentListImageBinding
import com.min.listApp.ui.base.BaseFragment
import com.min.listApp.ui.component.KakaoSearchListAdapter
import com.min.listApp.ui.constract.ListFragmentConstract
import com.min.listApp.ui.presenter.ListFragmentPresenter

private const val ARG_PARAM_CATEGORY = "KAKAO_CATEGORY"

class KakaoImageSearchListFragment : BaseFragment<FragmentListImageBinding>(resId = R.layout.fragment_list_image), ListFragmentConstract.View {

    override val presenter: ListFragmentConstract.Presenter = ListFragmentPresenter(this)

    override fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>) {
        @Suppress("UNCHECKED_CAST")
        (binding.list.adapter as? KakaoSearchListAdapter)?.let {
            it.setData(listItemModels.filterIsInstance<KakaoImageListItemModel>())
        }
    }

    override fun initLayout() {
        binding.list.adapter = KakaoSearchListAdapter()
    }

    fun searchKakao(keyword: String){
        presenter.searchKakao(keyword = keyword)
    }
}
