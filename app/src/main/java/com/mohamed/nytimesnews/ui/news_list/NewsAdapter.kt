package com.mohamed.nytimesnews.ui.news_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.nytimesnews.databinding.NewsItemBinding
import com.mohamed.nytimesnews.models.news.ui.News


class NewsAdapter(private val newsList: List<News> = listOf(), private val onClick: (News) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        with(holder) {
            binding.tvTitle.text = news.title
            binding.tvAuthor.text = news.author
            binding.tvDate.text = news.date
            binding.root.setOnClickListener {
                onClick(news)
            }
        }

    }


    class ViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)
}

