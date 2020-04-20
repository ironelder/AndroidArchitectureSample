package com.min.listApp.ui.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.min.listApp.R
import com.min.listApp.data.model.KakaoWebListItemModel
import com.min.listApp.databinding.ItemListWebBinding
import com.min.listApp.ui.base.BaseViewHolder
import com.min.listApp.util.ColorUtil

class KakaoSearchListWebHolder(parent: ViewGroup) : BaseViewHolder<ItemListWebBinding, KakaoWebListItemModel>(
    DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_web, parent, false)
) {

    override fun bind(data: KakaoWebListItemModel) {
        binding.apply {
            item = data
            binding.root.setBackgroundColor(ColorUtil.randomColor())
            binding.executePendingBindings()
        }
    }
}