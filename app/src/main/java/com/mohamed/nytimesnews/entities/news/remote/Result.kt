package com.mohamed.nytimesnews.entities.news.remote

data class Result(
    val abstract: String = "",
    val adx_keywords: String = "",
    val asset_id: Long = 0,
    val byline: String = "",
    val desFacet: List<String> = listOf(),
    val etaId: Int = 0,
    val geo_facet: List<String> = listOf(),
    val id: Long = 0,
    val media: List<Media> = listOf(),
    val nytdsection: String = "",
    val org_facet: List<String> = listOf(),
    val per_facet: List<String> = listOf(),
    val published_date: String = "",
    val section: String = "",
    val source: String = "",
    val subsection: String = "",
    val title: String = "",
    val type: String = "",
    val updated: String = "",
    val uri: String = "",
    val url: String = ""
)