package com.example.part2ch4lookupgithub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.part2ch4lookupgithub.databinding.ItemUserBinding
import com.example.part2ch4lookupgithub.model.User

class UserAdapter(val onClick: (User) -> Unit): ListAdapter<User, UserAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val viewBinding: ItemUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: User) {
            viewBinding.usernameTextView.text = item.username
            viewBinding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<User>() {  // diffUtil이 하는 일 잘 알아두기 -> oldItem과 newItem이 같은 친구인지
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = currentList[position]
        holder.bind(currentList[position])
    }
}