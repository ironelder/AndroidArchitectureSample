package com.min.listApp.ui.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.data.repository.KakaoSearchRepositoryImpl
import com.min.listApp.databinding.FragmentListImageBinding
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.ui.base.BaseFragment
import com.min.listApp.ui.component.KakaoSearchListAdapter
import com.min.listApp.ui.viewmodel.KakaoImageListViewModel

private const val ARG_PARAM_CATEGORY = "KAKAO_CATEGORY"

class KakaoImageSearchListFragment : BaseFragment<FragmentListImageBinding>(resId = R.layout.fragment_list_image) {

    @BindingAdapter("setListItems")
    fun setListItems(recyclerView: RecyclerView, items: List<KakaoListItemModel>) {
        (recyclerView.adapter as? KakaoSearchListAdapter)?.let {
            it.setData(items)
        }
    }
//    override val presenter: ListFragmentConstract.Presenter = ListFragmentPresenter(this)
    fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>) {
        @Suppress("UNCHECKED_CAST")
        (binding.list.adapter as? KakaoSearchListAdapter)?.let {
            it.setData(listItemModels.filterIsInstance<KakaoImageListItemModel>())
        }
    }

    override fun initLayout() {
        binding.list.adapter = KakaoSearchListAdapter()
        binding.listVM = KakaoImageListViewModel(kakaoSearchUseCase = KakaoSearchUseCase(KakaoSearchRepositoryImpl))
    }

    fun searchKakao(keyword: String){
//        presenter.searchKakao(keyword = keyword)
    }

}
