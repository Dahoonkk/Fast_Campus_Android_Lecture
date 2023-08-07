package com.android.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.android.databinding.ItemVideoBinding
import com.android.list.ItemHandler
import com.android.model.ListItem
import com.android.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }

}