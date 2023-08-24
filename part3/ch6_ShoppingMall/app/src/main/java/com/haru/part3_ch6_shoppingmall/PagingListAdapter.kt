package com.haru.part3_ch6_shoppingmall

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.haru.part3_ch6_shoppingmall.model.ListItem
import com.haru.part3_ch6_shoppingmall.viewHolder.BindingViewHolder
import com.haru.part3_ch6_shoppingmall.viewHolder.ViewHolderGenerator

class PagingListAdapter :
    PagingDataAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if(item != null) {
            holder.bind(item)
        }
    }
}