package com.min.listApp.data.model

data class KakaoListModel<T : KakaoListItemModel>(
    val kakaoListMetaModel: KakaoListMeta,
    val listItemModels: List<T>
)