package com.jun.mvstudy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jun.mvstudy.R
import com.jun.mvstudy.databinding.StudyListItemBinding
import com.jun.mvstudy.model.response.ImageSearchResponse

class StudySearchAdapter : RecyclerView.Adapter<StudySearchAdapter.StudyViewHolder>() {
    data class ImageItem(var imageUrl:String, var documentUrl:String)

    private var searchItemList = mutableListOf<ImageItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyViewHolder {
        return StudyViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.study_list_item,
            parent,
            false))
    }

    override fun getItemCount() = searchItemList.size

    override fun onBindViewHolder(holder: StudyViewHolder, position: Int) {
        val item = searchItemList[position]
        holder.apply {
            onBind(item)
        }
    }

    class StudyViewHolder(val binding : StudyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(searchItem : ImageItem) {
            binding.apply {
                Glide.with(root.context).setDefaultRequestOptions(
                    RequestOptions().placeholder(R.color.audio_list_thumbnail_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)).load(searchItem.imageUrl).into(binding.audioThumbnail)
                binding.audioName.text = searchItem.documentUrl
            }
        }
    }

    fun addItem(item: ImageItem) {
        searchItemList.add(item)
    }

    // 무엇인지 고민
    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

}