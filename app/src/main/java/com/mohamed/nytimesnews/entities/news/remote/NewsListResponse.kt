package com.mohamed.nytimesnews.entities.news.remote

import com.mohamed.nytimesnews.entities.news.ui.News

data class NewsListResponse(
    val copyright: String = "",
    val numResults: Int = 0,
    val results: List<Result> = listOf(),
    val status: String = ""
)

fun NewsListResponse.toUIModel(): List<News> {
    return this.results.map {
        News(
            title = it.title,
            description = it.abstract,
            author = it.byline,
            date = it.published_date
        )
    }
}