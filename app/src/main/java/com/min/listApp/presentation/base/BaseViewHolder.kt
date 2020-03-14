package com.min.listApp.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: ViewDataBinding, D>(val binding: T) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(data: D)
}