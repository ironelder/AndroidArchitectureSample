package com.min.listApp.ui.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.data.model.KakaoImageListItemModel

class KakaoSearchListAdapter : RecyclerView.Adapter<KakaoSearchListHolder>() {
    var mList = listOf<KakaoImageListItemModel>()

    fun setData(itemKakaos: List<KakaoImageListItemModel>){
        mList = itemKakaos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoSearchListHolder =
        KakaoSearchListHolder(parent)

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: KakaoSearchListHolder, position: Int) {
        mList[position].let { item ->
            with(holder) {
                bind(item)
            }
        }
    }
}