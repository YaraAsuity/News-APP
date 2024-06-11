package com.yara.thenewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.yara.thenewsapp.models.Article
import java.security.AccessControlContext
import java.util.concurrent.locks.Lock

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun getArticleDAO():ArticleDAO
    companion object{
        @Volatile
        private var instance:ArticleDatabase?=null
        private val LOCK=Any()
        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: createDatabase (context).also {
                instance = it
            }
        }
        private fun createDatabase (context: Context) =
            Room. databaseBuilder(
                context.applicationContext, ArticleDatabase:: class. java,
                "article_db.db"
        ).build()
    }
}