package com.ironelder.androidarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchListItemViewHolder>() {

    private lateinit var mItemList: List<Any>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListItemViewHolder {
        return SearchListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listitem,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: SearchListItemViewHolder, position: Int) {
    }

    inner class SearchListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}