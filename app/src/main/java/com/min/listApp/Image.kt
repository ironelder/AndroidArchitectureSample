package com.min.listApp

data class Image(
    val meta: ImageMeta,
    val documents: List<ImageDocument>
)

data class ImageMeta(
    val total_count: Int,
    val pageable_count: Int,
    val is_end: Boolean
)

data class ImageDocument(
    val collection: String,
    val thumbnail_url: String,
    val image_url: String,
    val width: Int,
    val height: Int,
    val display_sitename: String,
    val doc_url: String,
    val datetime: String
)