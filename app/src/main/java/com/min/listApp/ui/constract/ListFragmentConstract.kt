package com.min.listApp.ui.constract

import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.ui.base.BaseConstract
import com.min.listApp.ui.base.BasePresenter

interface ListFragmentConstract {
    interface View : BaseConstract.View {
        fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>)
    }

    interface Presenter : BaseConstract.Presenter {
        fun searchKakao(keyword: String)
        fun setCategory(category: String)
    }
}