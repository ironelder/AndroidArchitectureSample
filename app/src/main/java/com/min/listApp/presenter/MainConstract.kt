package com.min.listApp.presenter

import com.min.listApp.model.ImageDocument

interface MainConstract {
    interface View: BaseView<MainPresenter>{
        fun updateList(documents: List<ImageDocument>)
    }

    interface Presenter: BasePresenter{
        fun search(keyword: String)
    }
}
