package com.example.codingtest.ui.newslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.codingtest.data.model.Article
import com.example.codingtest.databinding.WidgetArticleItemBinding
import com.example.codingtest.extentions.displayDateTime
import com.example.codingtest.extentions.loadImage

class ArticlePagerAdapter(private val onItemClick: (Article) -> Unit) :
    PagingDataAdapter<Article, ArticlePagerAdapter.ArticleViewHolder>(ArticleComparator) {

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        getItem(position)?.let { article ->
            holder.bind(article, onItemClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WidgetArticleItemBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    class ArticleViewHolder(private val binding: WidgetArticleItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, onItemClick: (Article) -> Unit) {
            binding.imageNews.loadImage(article.urlToImage)
            binding.textTitle.text = article.title
            binding.textContent.text = article.description
            binding.textTimeUpdated.text = article.publishedAt?.displayDateTime()
            binding.root.setOnClickListener {
                onItemClick.invoke(article)
            }
        }
    }

    object ArticleComparator : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }
    }
}
