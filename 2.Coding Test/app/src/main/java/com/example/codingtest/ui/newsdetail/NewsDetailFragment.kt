package com.example.codingtest.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.codingtest.data.model.Article
import com.example.codingtest.databinding.FragmentNewsDetailBinding
import com.example.codingtest.extentions.displayDateTime
import com.example.codingtest.extentions.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private val viewModel: NewsDetailViewModel by viewModels()

    private lateinit var binding: FragmentNewsDetailBinding

    private lateinit var article: Article

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    private fun initData() {
        article = NewsDetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
    }

    private fun initView() {
        setupAppBar()
        setupArticleView()
    }

    private fun setupArticleView() {
        binding.apply {
            imageNews.loadImage(article.urlToImage)
            textTitle.text = article.title
            textContent.text = article.description
            textUpdatedTime.text = article.publishedAt?.displayDateTime()
        }
    }

    private fun setupAppBar() {
        binding.apply {
            appbar.apply {
                textViewTitle.text = null
                textViewBack.isVisible = true
                viewSearchBar.layoutSearch.isVisible = false
                toolbar.setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
                textViewBack.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }
}