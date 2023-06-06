package com.example.part2_chap6_chatapp.userList

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.part2_chap6_chatapp.chatdetail.ChatItem
import com.example.part2_chap6_chatapp.databinding.ItemChatBinding

class ChatAdapter : ListAdapter<ChatItem, ChatAdapter.ViewHolder>(differ) {

    var otherUserItem: UserItem? = null

    inner class ViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatItem) {
            if(item.userId == otherUserItem?.userId) {
                binding.usernameTextView.isVisible = true
                binding.usernameTextView.text = otherUserItem?.username
                binding.messageTextView.text = item.message
                binding.messageTextView.gravity = Gravity.START
            } else {
                binding.usernameTextView.isVisible = false
                binding.messageTextView.text = item.message
                binding.messageTextView.gravity = Gravity.END
            }
        }
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<ChatItem>() {
            override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem.chatId == newItem.chatId
            }

            override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        return ViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}