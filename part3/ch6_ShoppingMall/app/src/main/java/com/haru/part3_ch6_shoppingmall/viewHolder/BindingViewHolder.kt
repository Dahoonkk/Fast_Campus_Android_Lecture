package com.haru.part3_ch6_shoppingmall.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.haru.part3_ch6_shoppingmall.BR
import com.haru.part3_ch6_shoppingmall.model.ListItem


abstract class BindingViewHolder<VB : ViewDataBinding>(
    private val binding: VB,
) : RecyclerView.ViewHolder(binding.root) {

    protected var item: ListItem? = null

    open fun bind(item: ListItem) {
        this.item = item
        binding.setVariable(BR.item, this.item)
    }
}