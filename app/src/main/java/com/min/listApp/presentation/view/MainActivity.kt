package com.min.listApp.presentation.view

import android.view.inputmethod.EditorInfo
import android.widget.RadioButton
import com.min.listApp.R
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.presentation.base.BaseActivity
import com.min.listApp.presentation.constract.MainConstract
import com.min.listApp.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainConstract.View, MainConstract.Presenter>(R.layout.activity_main), MainConstract.View {

    override var presenter: MainConstract.Presenter = MainPresenter(this)
    override fun updateList(listItemModels: List<KakaoListItemModel>) {
        (listItemModels as? List<KakaoImageListItemModel>)?.let { /*list_main.adapter = MainListAdapter(it)*/ }
    }

    override fun initLayout() {
        search_input.setOnEditorActionListener { textView, actionId, _ ->

            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> presenter.searchKakao(keyword = textView.text.toString())
            }

            return@setOnEditorActionListener true
        }

        category_list_group.setOnCheckedChangeListener { group, id ->
            presenter.setCategory(category = group.findViewById<RadioButton>(id).getTag() as? String ?: "image")
        }
    }
}

