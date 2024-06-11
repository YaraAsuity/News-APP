package com.yara.thenewsapp.api

import com.yara.thenewsapp.models.NewsResponse
import com.yara.thenewsapp.uitl.Constant.Companion.APT_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode: String="us",
        @Query("page")
        pageNumber: Int=1,
        @Query("apiKey")
        apiKey : String= APT_KEY
    ):Response<NewsResponse>
    @GET ("v2/everything")
    suspend fun
            searchForNews (
        @Query ("q")
        searchQuery: String,
        @Query ("page")
        pageNumber: Int = 1,
        @Query ("apiKey")
        apiKey: String = APT_KEY
    ): Response<NewsResponse>

}