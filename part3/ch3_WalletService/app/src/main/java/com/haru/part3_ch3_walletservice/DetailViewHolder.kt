package com.haru.part3_ch3_walletservice

import androidx.recyclerview.widget.RecyclerView
import com.haru.part3_ch3_walletservice.databinding.ItemDetailBinding
import com.haru.part3_ch3_walletservice.model.DetailItem

class DetailViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DetailItem) {
        binding.item = item
    }

}