package com.min.listApp.data.entity

data class KakaoSearchEntity(
    val meta: KakaoSearchMetaEntity,
    val documents: List<KakaoSearchDocumentEntity>
)