package com.min.listApp.view

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.min.listApp.model.ImageDocument
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_list_item.view.*
import kotlin.random.Random

class MainListAdapter(val items: List<ImageDocument>) : RecyclerView.Adapter<MainListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder =
        MainListHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        items[position].let { item ->
            with(holder) {
                itemView.textView.text = "${item.display_sitename} <${item.collection}>"
                Picasso.get().load(item.thumbnail_url).into(itemView.imageView)
                itemView.setBackgroundColor(Color.rgb(Random.nextInt(0,255), Random.nextInt(0,255), Random.nextInt(0,255)))
            }
        }
    }
}