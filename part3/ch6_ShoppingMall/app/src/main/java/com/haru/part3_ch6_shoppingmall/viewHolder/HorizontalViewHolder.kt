package com.haru.part3_ch6_shoppingmall.viewHolder

import com.haru.part3_ch6_shoppingmall.ListAdapter
import com.haru.part3_ch6_shoppingmall.databinding.ItemHorizontalBinding
import com.haru.part3_ch6_shoppingmall.model.Horizontal
import com.haru.part3_ch6_shoppingmall.model.ListItem


class HorizontalViewHolder(
    private val binding: ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding) {
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}