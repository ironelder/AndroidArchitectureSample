package com.min.listApp.domain.kakaoSearch

import com.min.listApp.data.mapper.KakaoSearchEntityMapper
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.data.model.KakaoListModel
import com.min.listApp.data.repository.KakaoSearchRepository
import com.min.listApp.data.repository.KakaoSearchRepositoryImpl

class KakaoSearchUseCase {
    val kakaoRepository: KakaoSearchRepository =
        KakaoSearchRepositoryImpl

    fun getSearch (
        category: String,
        keyword: String,
        sort: String = "recency",
        page: Int = 1,
        size: Int = 80,
        responseSuccess: ((response: KakaoListModel<KakaoListItemModel>) -> Unit),
        responseFailure: (message: String) -> Unit
    ) {
        kakaoRepository.search(
            category = category,
            query = keyword,
            sort = sort,
            page = page,
            size = size,
            response = {
                responseSuccess(KakaoSearchEntityMapper.toImageListModel(it))
            },
            failure = {
                responseFailure(it)
            })
    }


}