package com.min.listApp.presentation.view.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.data.model.ImageListItemModel
import com.min.listApp.util.ColorUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_list_item.view.*

class MainListAdapter(val items: List<ImageListItemModel>) : RecyclerView.Adapter<MainListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder =
        MainListHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        items[position].let { item ->
            with(holder) {
                itemView.textView.text = "${item.display_sitename} <${item.collection}>"
                Picasso.get().load(item.thumbnail_url).into(itemView.imageView)
                itemView.setBackgroundColor(ColorUtil.randomColor())
            }
        }
    }
}