package com.jun.mvstudy.mvp

import com.jun.mvstudy.ui.StudySearchAdapter

interface IMvpView {
    fun setKakaoData(imageItem: StudySearchAdapter.ImageItem)
}