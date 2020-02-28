package com.min.listApp.presenter

import com.min.listApp.model.ImageDocument

interface MainConstract {
    interface View: BaseConstract.View<Presenter>{
        fun updateList(documents: List<ImageDocument>)
    }

    interface Presenter: BaseConstract.Presenter{
        fun search(keyword: String)
    }
}
