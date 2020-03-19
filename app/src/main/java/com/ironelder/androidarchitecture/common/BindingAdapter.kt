package com.ironelder.androidarchitecture.common

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.component.SearchListAdapter
import com.ironelder.androidarchitecture.data.model.ListItem

@BindingAdapter("setListItems")
fun setListItems(view: RecyclerView, items: List<ListItem>?) {
    val adapter: SearchListAdapter = view.adapter as SearchListAdapter
    adapter.setDocumentData(items)
}

@BindingAdapter("loadImageUrl")
fun loadImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).centerCrop()
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background).into(view)
}