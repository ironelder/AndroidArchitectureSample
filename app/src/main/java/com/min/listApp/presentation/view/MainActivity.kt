package com.min.listApp.presentation.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.min.listApp.R
import com.min.listApp.data.model.ImageDocument
import com.min.listApp.presentation.base.BaseActivity
import com.min.listApp.presentation.constract.MainConstract
import com.min.listApp.presentation.presenter.MainPresenter
import com.min.listApp.presentation.view.component.MainListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainConstract.View, MainConstract.Presenter>(R.layout.activity_main), MainConstract.View {

    override var presenter: MainConstract.Presenter = MainPresenter(this)

    override fun initLayout() {
        list_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun updateList(documents: List<ImageDocument>) {
        list_main.adapter =
            MainListAdapter(documents)
    }
}

