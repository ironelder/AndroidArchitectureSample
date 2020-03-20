package com.min.listApp.presentation.constract

import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.presentation.base.BaseConstract

interface ListFragmentConstract {
    interface View : BaseConstract.View {
        fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>)
    }

    interface Presenter : BaseConstract.Presenter<View> {
        fun searchKakao(keyword: String)
        fun setCategory(category: String)
    }
}