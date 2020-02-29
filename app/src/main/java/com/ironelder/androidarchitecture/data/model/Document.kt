package com.ironelder.androidarchitecture.data.model

data class Document(
    val contents: String,
    val datetime: String,
    val title: String,
    val thumbnail: String,
    val url: String
)