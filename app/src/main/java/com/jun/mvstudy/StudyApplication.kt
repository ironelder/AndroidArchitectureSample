package com.jun.mvstudy

import android.app.Application
import com.jun.mvstudy.di.studyModule
import org.koin.android.ext.android.startKoin

class StudyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, studyModule)
    }
}