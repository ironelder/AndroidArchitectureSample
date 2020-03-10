package com.min.listApp.presentation.constract

import com.min.listApp.data.model.ImageListItemModel
import com.min.listApp.presentation.base.BaseConstract

interface MainConstract {
    interface View : BaseConstract.View {
        fun updateList(listItemModels: List<ImageListItemModel>)
    }

    interface Presenter : BaseConstract.Presenter<View> {
        fun searchKakao(keyword: String)
        fun setCategory(category: String)
    }
}
