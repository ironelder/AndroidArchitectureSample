package com.min.listApp.ui.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.data.model.KakaoWebListItemModel


class KakaoSearchListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mList = listOf<KakaoListItemModel>()

    private val TYPE_IMAGE = 1
    private val TYPE_WEB = 2
    private val TYPE_UNKNOWN = -1

    fun setData(itemKakaos: List<KakaoListItemModel>){
        mList = itemKakaos
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = when (mList[position]) {
        is KakaoImageListItemModel -> TYPE_IMAGE
        is KakaoWebListItemModel -> TYPE_WEB
        else -> TYPE_UNKNOWN
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        TYPE_IMAGE -> KakaoSearchListImageHolder(parent)
        TYPE_WEB -> KakaoSearchListWebHolder(parent)
        else -> KakaoSearchListImageHolder(parent)
    }


    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_IMAGE -> (mList[position] as? KakaoImageListItemModel)?.let { (holder as? KakaoSearchListImageHolder)?.bind(it) }
            TYPE_WEB -> (mList[position] as? KakaoWebListItemModel)?.let { (holder as? KakaoSearchListWebHolder)?.bind(it) }
            else -> {}
        }
    }
}