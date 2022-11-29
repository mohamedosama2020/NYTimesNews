package com.mohamed.nytimesnews.entities.news.ui

import java.io.Serializable


data class News(
    val title:String="",
    val description:String="",
    val author:String="",
    val date:String="",
): Serializable
