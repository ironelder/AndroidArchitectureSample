package com.jun.mvstudy.ui

import android.os.Bundle
import android.util.Log
import com.jun.mvstudy.R
import com.jun.mvstudy.databinding.ActivityMainBinding
import com.jun.mvstudy.model.Restful
import com.jun.mvstudy.model.response.ImageSearchResponse
import com.jun.mvstudy.model.service.KakaoSearchService
import com.jun.mvstudy.mvp.IMvpView
import com.jun.mvstudy.mvp.MvpPresenter
import com.jun.mvstudy.ui.ui.base.BaseActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(), IMvpView {
    override fun getLayoutResId() = R.layout.activity_main
    lateinit var presenter : MvpPresenter
    lateinit var kakaoSearchService : KakaoSearchService
    lateinit var searchList : Single<ImageSearchResponse>
    lateinit var searchAdapter: StudySearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kakaoSearchService = Restful.buildRetrofit("https://dapi.kakao.com").create(KakaoSearchService::class.java)
        presenter = MvpPresenter(this, kakaoSearchService)
    }

    override fun initView() {
        study_recycler_view.run {
            adapter = StudySearchAdapter()
            searchAdapter = adapter as StudySearchAdapter
            setHasFixedSize(true) // 무엇?
        }

        edit_search_button.setOnClickListener {
            presenter.requestKakaoList(edit_search.text.toString())
        }
    }

    override fun setKakaoData(imageItem: StudySearchAdapter.ImageItem) {
        imageItem?.let {
            searchAdapter.addItem(it)
            searchAdapter.notifyDataSetChanged()
        }
    }
}
