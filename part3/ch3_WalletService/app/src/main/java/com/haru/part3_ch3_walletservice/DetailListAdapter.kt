package com.haru.part3_ch3_walletservice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.haru.part3_ch3_walletservice.databinding.ItemDetailBinding
import com.haru.part3_ch3_walletservice.model.DetailItem

class DetailListAdapter: ListAdapter<DetailItem, DetailViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffCallback: DiffUtil.ItemCallback<DetailItem>() {
        override fun areItemsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean {
            return oldItem == newItem
        }

    }
}