package com.min.listApp.presentation.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.data.model.KakaoImageListItemModel

class KakaoSearchListAdapter(val itemKakaos: List<KakaoImageListItemModel>) : RecyclerView.Adapter<KakaoSearchListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoSearchListHolder =
        KakaoSearchListHolder(parent)

    override fun getItemCount(): Int = itemKakaos.size

    override fun onBindViewHolder(holder: KakaoSearchListHolder, position: Int) {
        itemKakaos[position].let { item ->
            with(holder) {
                bind(item)
            }
        }
    }
}