package com.min.listApp.presentation.constract

import com.min.listApp.presentation.base.BaseConstract
import com.min.listApp.presentation.base.BasePresenter

interface MainConstract {
    interface View : BaseConstract.View
    abstract class Presenter(view: View) : BasePresenter<View>(view)
}
