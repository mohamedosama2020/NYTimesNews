package com.mohamed.nytimesnews.data

import com.mohamed.nytimesnews.entities.news.remote.NewsListResponse
import retrofit2.Response

class NYRepository(private val apiService: ApiService) {
    suspend fun getNewsList():Response<NewsListResponse>{
        return apiService.getNewsList()
    }
}