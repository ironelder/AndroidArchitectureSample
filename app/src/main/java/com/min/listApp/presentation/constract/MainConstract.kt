package com.min.listApp.presentation.constract

import com.min.listApp.data.model.ImageDocument
import com.min.listApp.presentation.base.BaseConstract

interface MainConstract {
    interface View:
        BaseConstract.View {
        fun updateList(documents: List<ImageDocument>)
    }

    interface Presenter:
        BaseConstract.Presenter<View> {
        fun search(keyword: String)
    }
}
