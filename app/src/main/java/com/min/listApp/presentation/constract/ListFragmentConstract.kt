package com.min.listApp.presentation.constract

import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.presentation.base.BaseConstract
import com.min.listApp.presentation.base.BasePresenter

interface ListFragmentConstract {
    interface View : BaseConstract.View {
        fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>)
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view = view) {
        abstract fun searchKakao(keyword: String)
        abstract fun setCategory(category: String)
    }
}