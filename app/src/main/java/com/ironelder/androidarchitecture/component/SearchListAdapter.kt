package com.ironelder.androidarchitecture.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.data.model.Document
import kotlinx.android.synthetic.main.listitem.view.*

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchListItemViewHolder>() {

    private var mItemList: ArrayList<Document> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListItemViewHolder {
        return SearchListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listitem,
                parent,
                false
            )
        )
    }

    fun setDocumentData(itemList:List<Document>?){
        if(itemList != null){
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
        fun setData(dc: Document){
            Glide.with(view.rootView.context).load(dc.thumbnail).error(R.drawable.ic_launcher_background).into(view.iv_thumbnail)
            view.tv_title.text=HtmlCompat.fromHtml(dc.title, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }
}