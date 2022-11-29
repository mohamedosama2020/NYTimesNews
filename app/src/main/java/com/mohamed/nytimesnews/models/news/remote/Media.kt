package com.mohamed.nytimesnews.models.news.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val approvedForSyndication: Int = 0,
    val caption: String = "",
    val copyright: String = "",
    val mediaMetadata: List<MediaMetadata> = listOf(),
    val subtype: String = "",
    val type: String = ""
) : Parcelable