package com.ironelder.androidarchitecture.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.data.model.BlogListItem
import kotlinx.android.synthetic.main.listitem.view.*

class SearchListAdapter<T> : RecyclerView.Adapter<SearchListAdapter<T>.SearchListItemViewHolder>() {

    private var mItemList: ArrayList<T> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListItemViewHolder {
        return SearchListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listitem,
                parent,
                false
            )
        )
    }

    fun setDocumentData(itemList: List<T>?) {
        if (itemList != null) {
            mItemList.addAll(itemList)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: SearchListItemViewHolder, position: Int) {
        holder.setData(mItemList[position])
    }

    inner class SearchListItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(dc: T) {
            Glide.with(view.rootView.context).load((dc as BlogListItem).thumbnail)
                .error(R.drawable.ic_launcher_background).into(view.iv_thumbnail)
            view.tv_title.text = HtmlCompat.fromHtml(dc.title, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }
}