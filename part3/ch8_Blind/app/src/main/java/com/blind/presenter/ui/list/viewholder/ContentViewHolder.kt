package com.blind.presenter.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.blind.databinding.ItemContentBinding
import com.blind.domain.model.Content
import com.blind.presenter.ui.MainActivity

class ContentViewHolder(
    private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Content) {
        binding.item = item
        binding.handler = handler
    }
}