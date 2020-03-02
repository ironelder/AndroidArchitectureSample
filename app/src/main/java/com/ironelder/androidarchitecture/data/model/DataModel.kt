package com.ironelder.androidarchitecture.data.model

import com.ironelder.androidarchitecture.data.entity.Meta

data class DataModel<T>(
    val listItems: List<T>,
    val is_end: Boolean
)