package com.min.listApp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.min.listApp.model.Image
import com.min.listApp.R
import com.min.listApp.model.ImageDocument
import com.min.listApp.model.SearchRetrofit
import com.min.listApp.presenter.MainConstract
import com.min.listApp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity: BaseActivity(), MainConstract.View {
    override lateinit var presenter: MainConstract.Presenter

    override fun initLayout() {
        list_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var presenter = MainPresenter(this)
        presenter.start()
        presenter.search("코로나")
    }

    override fun updateList(documents: List<ImageDocument>) {
        list_main.adapter = MainListAdapter(documents)
    }
}

