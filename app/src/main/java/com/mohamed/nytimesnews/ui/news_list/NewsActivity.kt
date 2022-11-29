package com.mohamed.nytimesnews.ui.news_list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.mohamed.nytimesnews.databinding.ActivityNewsBinding
import com.mohamed.nytimesnews.entities.news.ui.News
import com.mohamed.nytimesnews.ui.news_details.NewsDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private val viewModel: NewsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
    }

    private fun observeData() {
        viewModel.showLoading.observe(this) {
            showLoading(it)
        }
        viewModel.news.observe(this) {
            binding.rvList.adapter = NewsAdapter(it, ::onNewsItemClicked)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressIndicator.isVisible = isLoading
    }

    private fun onNewsItemClicked(news: News) {
        val intent = Intent(this, NewsDetailsActivity::class.java)
        intent.putExtra(NEWS_EXTRAS, news)
        startActivity(intent)
    }

    companion object {
        const val NEWS_EXTRAS = "News_Extras"
    }
}