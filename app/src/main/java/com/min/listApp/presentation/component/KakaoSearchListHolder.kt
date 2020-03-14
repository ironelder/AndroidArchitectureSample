package com.min.listApp.presentation.component

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.min.listApp.R
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.databinding.ItemListMainBinding
import com.min.listApp.presentation.base.BaseViewHolder
import com.min.listApp.util.ColorUtil
import com.squareup.picasso.Picasso

class KakaoSearchListHolder(parent: ViewGroup) : BaseViewHolder<ItemListMainBinding, KakaoImageListItemModel>(
    DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_main, parent, false)
) {
    override fun bind(data: KakaoImageListItemModel) {
        binding.apply {
            item = data
            holder = this@KakaoSearchListHolder
            binding.root.setBackgroundColor(ColorUtil.randomColor())
            binding.executePendingBindings()
        }
    }

}

@BindingAdapter(value = ["imageUrl"], requireAll = true)
fun loadImage(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}