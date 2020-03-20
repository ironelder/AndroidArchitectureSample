package com.min.listApp.domain.kakaoSearch

import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.mapper.KakaoSearchEntityMapper
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.data.model.KakaoListModel
import com.min.listApp.data.repository.KakaoSearchRepository
import com.min.listApp.data.repository.KakaoSearchRepositoryImpl
import io.reactivex.Single

class KakaoSearchUseCase(val kakaoRepository: KakaoSearchRepository) {

    fun getSearch (
        category: String,
        keyword: String,
        sort: String = "recency",
        page: Int = 1,
        size: Int = 80
    ): Single<KakaoListModel<KakaoListItemModel>> {

        return kakaoRepository.search(
            category = category,
            query = keyword,
            sort = sort,
            page = page,
            size = size).map {
            KakaoSearchEntityMapper.toListModel(it, category = KakaoCategory.fromString(category))
        }
    }
}