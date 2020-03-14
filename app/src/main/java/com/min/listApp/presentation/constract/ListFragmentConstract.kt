package com.min.listApp.presentation.constract

import com.min.listApp.presentation.base.BaseConstract

interface ListFragmentConstract {
    interface View : BaseConstract.View {
    }

    interface Presenter : BaseConstract.Presenter<View> {
    }
}