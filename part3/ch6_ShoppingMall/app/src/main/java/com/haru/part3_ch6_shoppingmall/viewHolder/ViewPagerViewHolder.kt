package com.haru.part3_ch6_shoppingmall.viewHolder


import com.haru.part3_ch6_shoppingmall.ListAdapter
import com.haru.part3_ch6_shoppingmall.databinding.ItemViewpagerBinding
import com.haru.part3_ch6_shoppingmall.model.ListItem
import com.haru.part3_ch6_shoppingmall.model.ViewPager

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}