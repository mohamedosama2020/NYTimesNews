package com.mohamed.nytimesnews.data
import com.mohamed.nytimesnews.BuildConfig
import com.mohamed.nytimesnews.models.news.remote.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("mostviewed/all-sections/7.json?api-key=${BuildConfig.API_KEY}")
    suspend fun getNewsList(): Response<NewsListResponse>
}