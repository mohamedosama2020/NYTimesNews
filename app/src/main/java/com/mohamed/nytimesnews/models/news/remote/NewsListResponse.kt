package com.mohamed.nytimesnews.models.news.remote

import android.os.Parcelable
import com.mohamed.nytimesnews.models.news.ui.News
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsListResponse(
    val copyright: String = "",
    val numResults: Int = 0,
    val results: List<Result> = listOf(),
    val status: String = ""
) : Parcelable

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