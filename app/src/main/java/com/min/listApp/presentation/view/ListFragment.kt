package com.min.listApp.presentation.view

import android.os.Bundle
import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.databinding.FragmentMainBinding
import com.min.listApp.presentation.base.BaseFragment
import com.min.listApp.presentation.component.KakaoSearchListAdapter
import com.min.listApp.presentation.constract.ListFragmentConstract
import com.min.listApp.presentation.presenter.ListFragmentPresenter

private const val ARG_PARAM_CATEGORY = "KAKAO_CATEGORY"

class ListFragment(resId: Int) : BaseFragment<ListFragmentConstract.View, ListFragmentConstract.Presenter, FragmentMainBinding>(resId), ListFragmentConstract.View {

    private var argParamCategory: KakaoCategory? = null
    override val presenter: ListFragmentConstract.Presenter = ListFragmentPresenter(this)

    companion object {
        @JvmStatic
        fun newInstance(category: KakaoCategory) =
            ListFragment(resId = R.layout.fragment_main).apply {
                arguments = Bundle().apply {
                     putString(ARG_PARAM_CATEGORY, category.categoryString)
                }
            }
    }

    override fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>) {
        @Suppress("UNCHECKED_CAST")
        (binding.listMain.adapter as? KakaoSearchListAdapter)?.let {
            when(argParamCategory){
                KakaoCategory.IMAGE -> it.setData(listItemModels.filterIsInstance<KakaoImageListItemModel>())
                else -> {}
            }
        }

    }

    override fun initLayout() {
        when(argParamCategory) {
            KakaoCategory.IMAGE -> binding.listMain.adapter = KakaoSearchListAdapter()
            else -> {}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            it.getString(ARG_PARAM_CATEGORY)?.let {
                argParamCategory = KakaoCategory.fromString(it)
            }
        }
        super.onCreate(savedInstanceState)
    }

    fun searchKakao(keyword: String){
        presenter.searchKakao(keyword = keyword)
    }

    fun setCategory(category: String){
        presenter.setCategory(category = category)
    }
}
