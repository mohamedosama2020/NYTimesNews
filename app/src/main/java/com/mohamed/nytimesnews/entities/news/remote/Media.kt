package com.mohamed.nytimesnews.entities.news.remote

data class Media(
    val approvedForSyndication: Int = 0,
    val caption: String = "",
    val copyright: String = "",
    val mediaMetadata: List<MediaMetadata> = listOf(),
    val subtype: String = "",
    val type: String = ""
)