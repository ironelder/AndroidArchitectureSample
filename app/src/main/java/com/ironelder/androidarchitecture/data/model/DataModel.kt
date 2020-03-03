package com.ironelder.androidarchitecture.data.model

import com.ironelder.androidarchitecture.data.entity.Meta

data class DataModel(
    val listItems: List<ListItem> = arrayListOf(),
    val is_end: Boolean = true
)