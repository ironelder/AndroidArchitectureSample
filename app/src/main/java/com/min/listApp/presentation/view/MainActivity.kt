package com.min.listApp.presentation.view

import android.view.inputmethod.EditorInfo
import android.widget.RadioButton
import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.data.model.KakaoWebListItemModel
import com.min.listApp.presentation.base.BaseActivity
import com.min.listApp.presentation.constract.MainConstract
import com.min.listApp.presentation.presenter.MainPresenter
import com.min.listApp.presentation.component.KakaoSearchListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : BaseActivity<MainConstract.View, MainConstract.Presenter>(R.layout.activity_main), MainConstract.View {

    override var presenter: MainConstract.Presenter = MainPresenter(this)
    var mainFragment: ListFragment = ListFragment.newInstance(KakaoCategory.IMAGE)


    override fun updateList(category: KakaoCategory, listItemModels: List<KakaoListItemModel>) = when (category) {
        //FIXME: Collections<T> 의 T의 경우 컴파일 시 타입이 제거됨, 이에 따라 타입캐스팅이 동작하지 못하게 되며, 이로 인해 오류가 발생할 수 있어 Warnning이 발생함
        KakaoCategory.WEB -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
        KakaoCategory.VCLIP -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
        KakaoCategory.IMAGE -> { mainFragment.list_main.adapter = KakaoSearchListAdapter(listItemModels as ArrayList<KakaoImageListItemModel>) }
        KakaoCategory.TIP -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
        KakaoCategory.CAFE -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
        KakaoCategory.BOOK -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
        KakaoCategory.BLOG -> {mainFragment.list_main.adapter = KakaoSearchListAdapter(ArrayList<KakaoImageListItemModel>())}
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

        supportFragmentManager.beginTransaction().replace(R.id.frame_main, mainFragment).commit()
    }
}

