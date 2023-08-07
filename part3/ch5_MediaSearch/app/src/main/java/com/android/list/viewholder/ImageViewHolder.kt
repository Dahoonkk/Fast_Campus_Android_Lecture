package com.android.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.android.databinding.ItemImageBinding
import com.android.list.ItemHandler
import com.android.model.ImageItem
import com.android.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ListItem) {
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }

}