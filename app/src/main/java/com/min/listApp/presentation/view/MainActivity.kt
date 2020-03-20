package com.min.listApp.presentation.view

import android.view.inputmethod.EditorInfo
import android.widget.RadioButton
import com.min.listApp.R
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.databinding.ActivityMainBinding
import com.min.listApp.presentation.base.BaseActivity
import com.min.listApp.presentation.constract.MainConstract
import com.min.listApp.presentation.presenter.MainPresenter


class MainActivity : BaseActivity<MainConstract.View, MainConstract.Presenter, ActivityMainBinding>(R.layout.activity_main), MainConstract.View {

    override var presenter: MainConstract.Presenter = MainPresenter(this)

    override fun initLayout() {
        binding.searchInput.setOnEditorActionListener { textView, actionId, _ ->

            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    (supportFragmentManager.findFragmentByTag("MainList") as? ListFragment)?.searchKakao(keyword = textView.text.toString())
                }
            }

            return@setOnEditorActionListener true
        }

        binding.categoryListGroup.setOnCheckedChangeListener { group, id ->
            var categoryString = group.findViewById<RadioButton>(id).getTag() as? String ?: "image"
            (supportFragmentManager.findFragmentByTag("MainList") as? ListFragment)?.setCategory(category = categoryString)
        }

        supportFragmentManager.beginTransaction().replace(R.id.frame_main, ListFragment.newInstance(KakaoCategory.IMAGE), "MainList").commit()
   }
}

