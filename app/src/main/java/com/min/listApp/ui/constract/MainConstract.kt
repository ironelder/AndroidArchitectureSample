package com.min.listApp.ui.constract

import com.min.listApp.ui.base.BaseConstract
import com.min.listApp.ui.base.BasePresenter

interface MainConstract {
    interface View : BaseConstract.View
    interface Presenter : BaseConstract.Presenter
//    abstract class Presenter(view: View) : BasePresenter<View>(view)
}
