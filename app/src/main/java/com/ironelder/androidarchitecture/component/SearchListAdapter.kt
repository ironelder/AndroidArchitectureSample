package com.ironelder.androidarchitecture.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.*

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchListItemViewHolder>() {

    private var mItemList: ArrayList<ListItem> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListItemViewHolder {
        val binding:ListitemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.listitem,
            parent,
            false
        )
        return SearchListItemViewHolder(binding)
    }

    fun setDocumentData(itemList: List<ListItem>?) {
        if (itemList != null) {
            mItemList.addAll(itemList)
        }
        notifyDataSetChanged()
    }

    fun addDocumentData(itemList: List<ListItem>?) {
        if (itemList != null) {
            mItemList.addAll(itemList)
            notifyItemRangeChanged(mItemList.size, itemList.size-1)
        }
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: SearchListItemViewHolder, position: Int) {
        holder.bind(mItemList[position])
    }

    class SearchListItemViewHolder(private val binding: ListitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:ListItem){
            binding.item = item
            binding.executePendingBindings()
        }
    }
}