package com.mohamed.nytimesnews.usecases

import com.mohamed.nytimesnews.data.NYRepository
import com.mohamed.nytimesnews.models.news.remote.NewsListResponse
import retrofit2.Response
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repo: NYRepository) {

    suspend operator fun invoke(): Response<NewsListResponse> {
        return repo.getNewsList()
    }

}