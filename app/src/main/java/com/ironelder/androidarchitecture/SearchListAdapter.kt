package com.ironelder.androidarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        fun setData(dc:Document){
            view.tv_title.text=dc.title
        }
    }
}