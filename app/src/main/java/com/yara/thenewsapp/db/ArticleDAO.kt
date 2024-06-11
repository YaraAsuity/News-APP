package com.yara.thenewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yara.thenewsapp.models.Article

interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend
    fun
            upsert(article: Article): Long
    @Query("SELECT * FROM articals")
    fun getAllArticles(): LiveData<List<Article>>
    @Delete
    suspend fun deleteArticle(article: Article)
}