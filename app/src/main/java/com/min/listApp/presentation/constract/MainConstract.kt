package com.min.listApp.presentation.constract

import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.presentation.base.BaseConstract

interface MainConstract {
    interface View : BaseConstract.View {
        fun updateList(listItemModels: List<KakaoListItemModel>)
    }

    interface Presenter : BaseConstract.Presenter<View> {
        fun searchKakao(keyword: String)
        fun setCategory(category: String)
    }
}
