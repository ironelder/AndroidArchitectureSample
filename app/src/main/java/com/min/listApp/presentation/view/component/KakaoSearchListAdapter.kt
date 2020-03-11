package com.min.listApp.presentation.view.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.data.model.KakaoImageListItemModel
import com.min.listApp.util.ColorUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_list_item.view.*

class KakaoSearchListAdapter(val itemKakaos: List<KakaoImageListItemModel>) : RecyclerView.Adapter<KakaoSearchListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoSearchListHolder =
        KakaoSearchListHolder(parent)

    override fun getItemCount(): Int = itemKakaos.size

    override fun onBindViewHolder(holder: KakaoSearchListHolder, position: Int) {
        itemKakaos[position].let { item ->
            with(holder) {
                itemView.textView.text = "${item.display_sitename} <${item.collection}>"
                Picasso.get().load(item.thumbnail_url).into(itemView.imageView)
                itemView.setBackgroundColor(ColorUtil.randomColor())
            }
        }
    }
}