package com.example.part2_ch10_tomorrowhouse.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.part2_ch10_tomorrowhouse.R
import com.example.part2_ch10_tomorrowhouse.data.ArticleModel
import com.example.part2_ch10_tomorrowhouse.databinding.ItemArticleBinding

class HomeArticleAdapter(
    val onItemClicked: (ArticleItem) -> Unit,
    val onBookamrkClicked: (String, Boolean) -> Unit,
) : ListAdapter<ArticleItem, HomeArticleAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(articleItem: ArticleItem) {
            binding.descriptionTextView.text = articleItem.description

            Glide.with(binding.thumbnailImageView)
                .load(articleItem.imageUrl)
                .into(binding.thumbnailImageView)

            binding.root.setOnClickListener {
                onItemClicked(articleItem)
            }

            if (articleItem.isBookMark) {
                binding.bookmarkImageButton.setBackgroundResource(R.drawable.baseline_bookmark_24)
            } else {
                binding.bookmarkImageButton.setBackgroundResource(R.drawable.baseline_bookmark_border_24)
            }

            binding.bookmarkImageButton.setOnClickListener {
                onBookamrkClicked.invoke(articleItem.articleId, articleItem.isBookMark.not())

                articleItem.isBookMark = articleItem.isBookMark.not()

                if (articleItem.isBookMark) {
                    binding.bookmarkImageButton.setBackgroundResource(R.drawable.baseline_bookmark_24)
                } else {
                    binding.bookmarkImageButton.setBackgroundResource(R.drawable.baseline_bookmark_border_24)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArticleItem>() {
            override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
                return oldItem.articleId == newItem.articleId
            }

            override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
                return oldItem == newItem
            }

        }
    }

}