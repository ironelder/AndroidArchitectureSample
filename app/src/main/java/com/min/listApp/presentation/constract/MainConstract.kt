package com.min.listApp.presentation.constract

import com.min.listApp.presentation.base.BaseConstract

interface MainConstract {
    interface View : BaseConstract.View { }

    interface Presenter : BaseConstract.Presenter<View> {

    }
}
