package com.mohamed.nytimesnews.ui.news_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamed.nytimesnews.databinding.ActivityNewsDetailsBinding
import com.mohamed.nytimesnews.entities.news.ui.News
import com.mohamed.nytimesnews.ui.news_list.NewsActivity.Companion.NEWS_EXTRAS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDataFromIntent()
    }

    private fun setDataFromIntent() {
        val news:News = intent.getSerializableExtra(NEWS_EXTRAS) as News
        with(binding){
            tvTitle.text = news.title
            tvDate.text = news.date
            tvAuthor.text = news.author
            tvDescription.text = news.description
        }
    }
}