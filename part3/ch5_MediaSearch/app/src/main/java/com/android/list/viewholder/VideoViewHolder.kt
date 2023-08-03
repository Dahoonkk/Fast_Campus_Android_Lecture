package com.android.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.android.databinding.ItemVideoBinding
import com.android.model.ListItem
import com.android.model.VideoItem

class VideoViewHolder(private val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ListItem) {
        item as VideoItem
        binding.item = item
    }

}