package com.mohamed.nytimesnews.ui.news_list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.mohamed.nytimesnews.databinding.ActivityMainBinding
import com.mohamed.nytimesnews.models.news.ui.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
        Toast.makeText(this, news.title, Toast.LENGTH_SHORT).show()
    }
}