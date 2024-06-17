package com.yara.thenewsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yara.thenewsapp.reprository.NewsRepository

class NewsViewModleProviderFactory (val app:Application, val newsRepository: NewsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModleProviderFactory(app,newsRepository)as T
    }

}