package com.example.part2_chap6_chatapp.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.part2_chap6_chatapp.chatList.ChatRoomItem
import com.example.part2_chap6_chatapp.databinding.ItemChatroomBinding

class ChatListAdapter : ListAdapter<ChatRoomItem, ChatListAdapter.ViewHolder>(differ) {

    inner class ViewHolder(private val binding: ItemChatroomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatRoomItem) {
            binding.nicknameTextView.text = item.otherUserName
            binding.lastMessageTextView.text = item.lastMessage
        }
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<ChatRoomItem>() {
            override fun areItemsTheSame(oldItem: ChatRoomItem, newItem: ChatRoomItem): Boolean {
                return oldItem.chatRoomId == newItem.chatRoomId
            }

            override fun areContentsTheSame(oldItem: ChatRoomItem, newItem: ChatRoomItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListAdapter.ViewHolder {
        return ViewHolder(
            ItemChatroomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatListAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}