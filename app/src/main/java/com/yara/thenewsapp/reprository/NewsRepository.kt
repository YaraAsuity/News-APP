package com.yara.thenewsapp.reprository

import androidx.room.Query
import com.yara.thenewsapp.api.RetrofitInstance
import com.yara.thenewsapp.db.ArticleDatabase
import com.yara.thenewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String,padeNumber: Int)=
        RetrofitInstance.api.getHeadlines(countryCode,padeNumber)
    suspend fun searchNews(searchQuery:  String,padeNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery,padeNumber)
    suspend fun upsert(article: Article)=db.getArticleDAO().upsert(article)
    fun getFavouriteNews()=db.getArticleDAO().getAllArticles()
    suspend fun deleteArticle(article: Article)=db.getArticleDAO().deleteArticle(article)


}